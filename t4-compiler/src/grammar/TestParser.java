import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.IOException;
import generated.*;

public class TestParser {
    public static void main(String[] args) throws Exception {
        String inputFile = "test_sample.t4";
        if (args.length > 0) inputFile = args[0];

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(inputFile));

        T4Lexer lexer = new T4Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        T4Parser parser = new T4Parser(tokens);

        parser.setBuildParseTree(true);
        RuleContext tree = parser.program();

        System.out.println("Parse successful!");
        System.out.println("Parse tree: " + tree.toStringTree(parser));
    }
}