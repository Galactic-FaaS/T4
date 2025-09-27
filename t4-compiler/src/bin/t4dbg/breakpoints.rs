//! Breakpoint management for T4 Debugger

use std::collections::HashMap;
use std::path::PathBuf;

#[derive(Debug, Clone)]
pub struct Breakpoint {
    pub id: usize,
    pub file: PathBuf,
    pub line: usize,
    pub condition: Option<String>,
    pub hit_count: usize,
    pub enabled: bool,
    pub temporary: bool,
}

pub struct BreakpointManager {
    breakpoints: HashMap<usize, Breakpoint>,
    next_id: usize,
    file_breakpoints: HashMap<PathBuf, Vec<usize>>,
}

impl BreakpointManager {
    pub fn new() -> Self {
        Self {
            breakpoints: HashMap::new(),
            next_id: 1,
            file_breakpoints: HashMap::new(),
        }
    }

    pub fn add_breakpoint_from_spec(&mut self, spec: &str) -> anyhow::Result<()> {
        // Parse breakpoint specification
        // Format: file:line or function_name
        if let Some((file, line_str)) = spec.split_once(':') {
            let file = PathBuf::from(file);
            let line: usize = line_str.parse()?;
            self.add_breakpoint(file, line, None)
        } else {
            // Function breakpoint
            self.add_function_breakpoint(spec.to_string())
        }
    }

    pub fn add_breakpoint(&mut self, file: PathBuf, line: usize, condition: Option<String>) -> anyhow::Result<()> {
        let id = self.next_id;
        self.next_id += 1;

        let breakpoint = Breakpoint {
            id,
            file: file.clone(),
            line,
            condition,
            hit_count: 0,
            enabled: true,
            temporary: false,
        };

        self.breakpoints.insert(id, breakpoint);

        // Add to file index
        self.file_breakpoints.entry(file).or_insert_with(Vec::new).push(id);

        println!("Breakpoint {} set at {}:{}", id, file.display(), line);
        Ok(())
    }

    pub fn add_function_breakpoint(&mut self, function: String) -> anyhow::Result<()> {
        let id = self.next_id;
        self.next_id += 1;

        // TODO: Resolve function name to file and line
        let file = PathBuf::from("unknown");
        let line = 0;

        let breakpoint = Breakpoint {
            id,
            file,
            line,
            condition: None,
            hit_count: 0,
            enabled: true,
            temporary: false,
        };

        self.breakpoints.insert(id, breakpoint);
        println!("Function breakpoint {} set for function: {}", id, function);
        Ok(())
    }

    pub fn remove_breakpoint(&mut self, id: usize) -> anyhow::Result<()> {
        if let Some(bp) = self.breakpoints.remove(&id) {
            // Remove from file index
            if let Some(file_bps) = self.file_breakpoints.get_mut(&bp.file) {
                file_bps.retain(|&x| x != id);
                if file_bps.is_empty() {
                    self.file_breakpoints.remove(&bp.file);
                }
            }
            println!("Breakpoint {} removed", id);
            Ok(())
        } else {
            Err(anyhow::anyhow!("Breakpoint {} not found", id))
        }
    }

    pub fn enable_breakpoint(&mut self, id: usize) -> anyhow::Result<()> {
        if let Some(bp) = self.breakpoints.get_mut(&id) {
            bp.enabled = true;
            println!("Breakpoint {} enabled", id);
            Ok(())
        } else {
            Err(anyhow::anyhow!("Breakpoint {} not found", id))
        }
    }

    pub fn disable_breakpoint(&mut self, id: usize) -> anyhow::Result<()> {
        if let Some(bp) = self.breakpoints.get_mut(&id) {
            bp.enabled = false;
            println!("Breakpoint {} disabled", id);
            Ok(())
        } else {
            Err(anyhow::anyhow!("Breakpoint {} not found", id))
        }
    }

    pub fn list_breakpoints(&self) -> Vec<&Breakpoint> {
        self.breakpoints.values().collect()
    }

    pub fn get_breakpoints_for_file(&self, file: &PathBuf) -> Vec<&Breakpoint> {
        if let Some(ids) = self.file_breakpoints.get(file) {
            ids.iter().filter_map(|id| self.breakpoints.get(id)).collect()
        } else {
            Vec::new()
        }
    }

    pub fn should_break(&self, file: &PathBuf, line: usize) -> Option<&Breakpoint> {
        let file_breakpoints = self.get_breakpoints_for_file(file);

        for bp in file_breakpoints {
            if bp.enabled && bp.line == line {
                // Check condition if present
                if let Some(condition) = &bp.condition {
                    // TODO: Evaluate condition
                    if self.evaluate_condition(condition) {
                        return Some(bp);
                    }
                } else {
                    return Some(bp);
                }
            }
        }

        None
    }

    pub fn hit_breakpoint(&mut self, id: usize) {
        if let Some(bp) = self.breakpoints.get_mut(&id) {
            bp.hit_count += 1;
        }
    }

    fn evaluate_condition(&self, _condition: &str) -> bool {
        // TODO: Implement condition evaluation
        true
    }
}