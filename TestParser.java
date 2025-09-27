import java.io.FileInputStream;
import java.io.IOException;

public class TestParser {
    public static void main(String[] args) throws Exception {
        String inputFile = "test_sample.t4";
        if (args.length > 0) inputFile = args[0];

        org.antlr.v4.runtime.ANTLRInputStream input = new org.antlr.v4.runtime.ANTLRInputStream(new FileInputStream(inputFile));

        generated.T4Lexer lexer = new generated.T4Lexer(input);
        org.antlr.v4.runtime.CommonTokenStream tokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
        generated.T4Parser parser = new generated.T4Parser(tokens);

        parser.setBuildParseTree(true);
        org.antlr.v4.runtime.tree.ParseTree tree = parser.program();

        System.out.println("Parse successful!");
        System.out.println("Parse tree: " + tree.toStringTree(parser));
    }
}