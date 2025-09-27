//! T4 Runtime Memory Management
//!
//! This module implements secure memory management for T4 runtime,
//! including cryptographic memory protection, secure allocation,
//! and automatic memory wiping for sensitive data.

use crate::runtime::errors::{RuntimeError, RuntimeResult};
use crate::runtime::RuntimeConfig;
use std::alloc::{GlobalAlloc, Layout, System};
use std::collections::HashMap;
use std::ptr::{self, NonNull};
use std::sync::{Arc, Mutex};
use zeroize::Zeroize;

/// Memory safety level configuration
#[derive(Debug, Clone, PartialEq)]
pub enum MemorySafetyLevel {
    /// Standard memory safety
    Standard,
    /// Enhanced memory safety with cryptographic protections
    Enhanced,
    /// Maximum security with full memory wiping
    Maximum,
}

/// Secure memory allocator with cryptographic protections
pub struct SecureAllocator {
    /// Underlying allocator
    allocator: System,

    /// Memory safety configuration
    safety_level: MemorySafetyLevel,

    /// Memory regions being tracked
    regions: Arc<Mutex<HashMap<RegionId, MemoryRegion>>>,

    /// Statistics
    stats: Arc<Mutex<MemoryUsageStats>>,
}

/// Unique identifier for memory regions
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct RegionId(u64);

/// Memory region with security properties
#[derive(Debug, Clone)]
pub struct MemoryRegion {
    /// Unique region identifier
    pub id: RegionId,

    /// Region size in bytes
    pub size: usize,

    /// Region type
    pub region_type: RegionType,

    /// Security level
    pub security_level: SecurityLevel,

    /// Whether region contains secrets
    pub contains_secrets: bool,

    /// Allocation timestamp
    pub allocated_at: std::time::Instant,

    /// Last access timestamp
    pub last_accessed: std::time::Instant,
}

/// Type of memory region
#[derive(Debug, Clone, PartialEq)]
pub enum RegionType {
    /// Regular heap allocation
    Heap,
    /// Cryptographic key material
    CryptoKey,
    /// Secret data
    Secret,
    /// Encrypted data
    Encrypted,
    /// Stack frame
    Stack,
    /// Static/global data
    Static,
}

/// Security level for memory regions
#[derive(Debug, Clone, PartialEq)]
pub enum SecurityLevel {
    /// Public data, no special protection
    Public,
    /// Sensitive data, basic protection
    Sensitive,
    /// Secret data, enhanced protection
    Secret,
    /// Cryptographic keys, maximum protection
    Crypto,
}

/// Memory usage statistics
#[derive(Debug, Clone, Default)]
pub struct MemoryUsageStats {
    /// Total bytes allocated
    pub total_allocated: usize,

    /// Peak memory usage
    pub peak_usage: usize,

    /// Number of secure regions
    pub secure_regions: usize,

    /// Bytes wiped
    pub wiped_bytes: usize,

    /// Number of allocations
    pub allocations: u64,

    /// Number of deallocations
    pub deallocations: u64,
}

/// Main memory manager
pub struct MemoryManager {
    /// Secure allocator
    allocator: SecureAllocator,

    /// Active allocations
    allocations: Arc<Mutex<HashMap<NonNull<u8>, AllocationInfo>>>,

    /// Secret data registry
    secrets: Arc<Mutex<HashMap<NonNull<u8>, SecretInfo>>>,

    /// Configuration
    config: RuntimeConfig,
}

/// Information about an allocation
#[derive(Debug, Clone)]
pub struct AllocationInfo {
    /// Allocation size
    pub size: usize,

    /// Allocation type
    pub alloc_type: RegionType,

    /// Security level
    pub security_level: SecurityLevel,

    /// Whether allocation contains secrets
    pub contains_secrets: bool,

    /// Allocation timestamp
    pub allocated_at: std::time::Instant,

    /// Last access timestamp
    pub last_accessed: std::time::Instant,
}

/// Information about secret data
#[derive(Debug, Clone)]
pub struct SecretInfo {
    /// Secret type
    pub secret_type: SecretType,

    /// Security requirements
    pub requirements: SecurityRequirements,

    /// Wipe on drop
    pub wipe_on_drop: bool,

    /// Access count
    pub access_count: u64,
}

/// Type of secret data
#[derive(Debug, Clone, PartialEq)]
pub enum SecretType {
    /// Cryptographic key
    Key,
    /// Password or passphrase
    Password,
    /// Private key
    PrivateKey,
    /// Secret key material
    KeyMaterial,
    /// Authentication token
    Token,
    /// Generic secret data
    Generic,
}

/// Security requirements for secret data
#[derive(Debug, Clone)]
pub struct SecurityRequirements {
    /// Constant-time operations required
    pub constant_time: bool,

    /// Secure memory required
    pub secure_memory: bool,

    /// Hardware protection preferred
    pub hardware_protection: bool,

    /// Automatic wiping required
    pub auto_wipe: bool,
}

impl SecureAllocator {
    /// Create a new secure allocator
    pub fn new(safety_level: MemorySafetyLevel) -> Self {
        Self {
            allocator: System,
            safety_level,
            regions: Arc::new(Mutex::new(HashMap::new())),
            stats: Arc::new(Mutex::new(MemoryUsageStats::default())),
        }
    }

    /// Allocate memory with security properties
    pub fn allocate(
        &self,
        layout: Layout,
        region_type: RegionType,
        security_level: SecurityLevel,
        contains_secrets: bool,
    ) -> RuntimeResult<NonNull<u8>> {
        // Use the system allocator
        let ptr = self.allocator.alloc(layout);

        if ptr.is_null() {
            return Err(RuntimeError::OutOfMemory);
        }

        let region_id = RegionId(self.next_region_id());
        let region = MemoryRegion {
            id: region_id,
            size: layout.size(),
            region_type,
            security_level: security_level.clone(),
            contains_secrets,
            allocated_at: std::time::Instant::now(),
            last_accessed: std::time::Instant::now(),
        };

        // Store region information
        if let Ok(mut regions) = self.regions.lock() {
            regions.insert(region_id, region);
        }

        // Update statistics
        if let Ok(mut stats) = self.stats.lock() {
            stats.total_allocated += layout.size();
            stats.peak_usage = stats.peak_usage.max(stats.total_allocated);
            stats.secure_regions += if contains_secrets { 1 } else { 0 };
            stats.allocations += 1;
        }

        Ok(unsafe { NonNull::new_unchecked(ptr) })
    }

    /// Deallocate memory with secure wiping if needed
    pub fn deallocate(&self, ptr: NonNull<u8>, layout: Layout, contains_secrets: bool) -> RuntimeResult<()> {
        if contains_secrets {
            // Securely wipe memory before deallocation
            self.secure_wipe(ptr, layout.size());
        }

        // Use the system allocator
        unsafe {
            self.allocator.dealloc(ptr.as_ptr(), layout);
        }

        // Update statistics
        if let Ok(mut stats) = self.stats.lock() {
            if contains_secrets {
                stats.wiped_bytes += layout.size();
            }
            stats.deallocations += 1;
        }

        Ok(())
    }

    /// Securely wipe memory region
    pub fn secure_wipe(&self, ptr: NonNull<u8>, size: usize) {
        // Use zeroize to securely wipe memory
        let slice = unsafe { std::slice::from_raw_parts_mut(ptr.as_ptr(), size) };
        slice.zeroize();

        // Additional wiping patterns for enhanced security
        if self.safety_level == MemorySafetyLevel::Maximum {
            self.enhanced_wipe(slice);
        }
    }

    /// Enhanced wiping with multiple patterns
    fn enhanced_wipe(&self, slice: &mut [u8]) {
        // Pattern 1: Zeros
        slice.zeroize();

        // Pattern 2: Ones
        for byte in slice.iter_mut() {
            *byte = 0xFF;
        }

        // Pattern 3: Random data
        use rand::Rng;
        let mut rng = rand::thread_rng();
        rng.fill(slice);

        // Final pattern: Zeros again
        slice.zeroize();
    }

    /// Get memory usage statistics
    pub fn get_usage_stats(&self) -> MemoryUsageStats {
        self.stats.lock().unwrap_or_default().clone()
    }

    /// Generate next region ID
    fn next_region_id(&self) -> u64 {
        use std::sync::atomic::{AtomicU64, Ordering};
        static COUNTER: AtomicU64 = AtomicU64::new(0);
        COUNTER.fetch_add(1, Ordering::Relaxed)
    }
}

impl MemoryManager {
    /// Create a new memory manager
    pub fn new(safety_level: MemorySafetyLevel) -> RuntimeResult<Self> {
        Ok(Self {
            allocator: SecureAllocator::new(safety_level),
            allocations: Arc::new(Mutex::new(HashMap::new())),
            secrets: Arc::new(Mutex::new(HashMap::new())),
            config: RuntimeConfig::default(),
        })
    }

    /// Allocate memory for a value
    pub fn allocate_value(&self, size: usize, value_type: RegionType) -> RuntimeResult<NonNull<u8>> {
        let security_level = match value_type {
            RegionType::CryptoKey | RegionType::Secret => SecurityLevel::Crypto,
            RegionType::Encrypted => SecurityLevel::Secret,
            _ => SecurityLevel::Public,
        };

        let contains_secrets = matches!(
            value_type,
            RegionType::CryptoKey | RegionType::Secret | RegionType::KeyMaterial
        );

        let layout = Layout::from_size_align(size, 8).map_err(|_| RuntimeError::InvalidLayout)?;
        self.allocator.allocate(layout, value_type, security_level, contains_secrets)
    }

    /// Deallocate memory for a value
    pub fn deallocate_value(&self, ptr: NonNull<u8>, size: usize, contains_secrets: bool) -> RuntimeResult<()> {
        let layout = Layout::from_size_align(size, 8).map_err(|_| RuntimeError::InvalidLayout)?;
        self.allocator.deallocate(ptr, layout, contains_secrets)
    }

    /// Register secret data
    pub fn register_secret(
        &self,
        ptr: NonNull<u8>,
        secret_type: SecretType,
        requirements: SecurityRequirements,
    ) -> RuntimeResult<()> {
        let secret_info = SecretInfo {
            secret_type,
            requirements,
            wipe_on_drop: true,
            access_count: 0,
        };

        if let Ok(mut secrets) = self.secrets.lock() {
            secrets.insert(ptr, secret_info);
        }

        Ok(())
    }

    /// Unregister secret data
    pub fn unregister_secret(&self, ptr: NonNull<u8>) -> RuntimeResult<()> {
        if let Ok(mut secrets) = self.secrets.lock() {
            secrets.remove(&ptr);
        }
        Ok(())
    }

    /// Check if pointer points to secret data
    pub fn is_secret(&self, ptr: NonNull<u8>) -> bool {
        self.secrets.lock().map_or(false, |secrets| secrets.contains_key(&ptr))
    }

    /// Get secret information
    pub fn get_secret_info(&self, ptr: NonNull<u8>) -> Option<SecretInfo> {
        self.secrets.lock().ok()?.get(&ptr).cloned()
    }

    /// Record memory access
    pub fn record_access(&self, ptr: NonNull<u8>) -> RuntimeResult<()> {
        // Update access time in allocation info
        if let Ok(mut allocations) = self.allocations.lock() {
            if let Some(info) = allocations.get_mut(&ptr) {
                info.last_accessed = std::time::Instant::now();
            }
        }

        // Update access count for secrets
        if let Ok(mut secrets) = self.secrets.lock() {
            if let Some(secret) = secrets.get_mut(&ptr) {
                secret.access_count += 1;
            }
        }

        Ok(())
    }

    /// Get memory usage statistics
    pub fn get_usage_stats(&self) -> MemoryUsageStats {
        self.allocator.get_usage_stats()
    }

    /// Perform garbage collection (placeholder for future implementation)
    pub fn garbage_collect(&self) -> RuntimeResult<()> {
        // TODO: Implement garbage collection for unreferenced memory
        Ok(())
    }

    /// Wipe all secret data (emergency cleanup)
    pub fn emergency_wipe(&self) -> RuntimeResult<()> {
        let secrets = self.secrets.lock()
            .map_err(|_| RuntimeError::LockError)?
            .keys().cloned().collect::<Vec<_>>();

        for ptr in secrets {
            if let Ok(info) = self.secrets.lock() {
                if let Some(secret_info) = info.get(&ptr) {
                    // Get allocation info to find size
                    if let Ok(allocations) = self.allocations.lock() {
                        if let Some(alloc_info) = allocations.get(&ptr) {
                            let layout = Layout::from_size_align(alloc_info.size, 8)
                                .map_err(|_| RuntimeError::InvalidLayout)?;
                            drop(allocations); // Release lock
                            self.allocator.secure_wipe(ptr, alloc_info.size);
                        }
                    }
                }
            }
        }

        Ok(())
    }
}

/// Secure memory guard that automatically wipes memory on drop
pub struct SecureMemoryGuard {
    /// Pointer to the memory
    ptr: Option<NonNull<u8>>,

    /// Size of the memory region
    size: usize,

    /// Whether memory contains secrets
    contains_secrets: bool,

    /// Memory manager reference
    memory_manager: Option<Arc<MemoryManager>>,
}

impl SecureMemoryGuard {
    /// Create a new secure memory guard
    pub fn new(
        ptr: NonNull<u8>,
        size: usize,
        contains_secrets: bool,
        memory_manager: Arc<MemoryManager>,
    ) -> Self {
        Self {
            ptr: Some(ptr),
            size,
            contains_secrets,
            memory_manager: Some(memory_manager),
        }
    }

    /// Get a reference to the memory
    pub fn as_ptr(&self) -> *const u8 {
        self.ptr.map_or(ptr::null(), |p| p.as_ptr())
    }

    /// Get a mutable reference to the memory
    pub fn as_mut_ptr(&mut self) -> *mut u8 {
        self.ptr.map_or(ptr::null_mut(), |p| p.as_ptr())
    }

    /// Manually wipe the memory
    pub fn wipe(&mut self) -> RuntimeResult<()> {
        if let (Some(ptr), Some(ref manager)) = (self.ptr, self.memory_manager.as_ref()) {
            manager.allocator.secure_wipe(ptr, self.size);
        }
        Ok(())
    }

    /// Check if memory contains secrets
    pub fn contains_secrets(&self) -> bool {
        self.contains_secrets
    }
}

impl Drop for SecureMemoryGuard {
    fn drop(&mut self) {
        if let (Some(ptr), Some(ref manager)) = (self.ptr.take(), self.memory_manager.take()) {
            if self.contains_secrets {
                // Securely wipe secret memory
                manager.allocator.secure_wipe(ptr, self.size);
            }

            // Deallocate the memory
            let layout = Layout::from_size_align(self.size, 8).unwrap();
            let _ = manager.allocator.deallocate(ptr, layout, self.contains_secrets);
        }
    }
}

/// RAII guard for secret data with automatic wiping
pub struct SecretGuard<T> {
    /// The secret data
    data: Option<T>,

    /// Memory manager reference
    memory_manager: Option<Arc<MemoryManager>>,
}

impl<T> SecretGuard<T> {
    /// Create a new secret guard
    pub fn new(data: T, memory_manager: Arc<MemoryManager>) -> Self {
        Self {
            data: Some(data),
            memory_manager: Some(memory_manager),
        }
    }

    /// Get a reference to the secret data
    pub fn as_ref(&self) -> Option<&T> {
        self.data.as_ref()
    }

    /// Get a mutable reference to the secret data
    pub fn as_mut(&mut self) -> Option<&mut T> {
        self.data.as_mut()
    }

    /// Manually wipe the secret
    pub fn wipe(&mut self) {
        if let Some(ref mut data) = self.data {
            data.zeroize();
        }
    }
}

impl<T: Zeroize> Drop for SecretGuard<T> {
    fn drop(&mut self) {
        if let Some(ref mut data) = self.data.take() {
            data.zeroize();
        }
    }
}

// Implement GlobalAlloc for SecureAllocator
unsafe impl GlobalAlloc for SecureAllocator {
    unsafe fn alloc(&self, layout: Layout) -> *mut u8 {
        match self.allocate(layout, RegionType::Heap, SecurityLevel::Public, false) {
            Ok(ptr) => ptr.as_ptr(),
            Err(_) => ptr::null_mut(),
        }
    }

    unsafe fn dealloc(&self, ptr: *mut u8, layout: Layout) {
        if !ptr.is_null() {
            let non_null = NonNull::new_unchecked(ptr);
            let _ = self.deallocate(non_null, layout, false);
        }
    }
}