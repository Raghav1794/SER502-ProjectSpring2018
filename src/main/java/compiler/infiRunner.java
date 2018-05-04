package compiler;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import runtime.Loader;

import java.io.FileInputStream;
import java.io.PrintWriter;

public class infinityRunner {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);
        ANTLRInputStream input = new ANTLRInputStream(fis);

        infinityLexer lexer = new infinityLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        infinityParser parser = new infinityParser(tokens);
        ParserRuleContext tree = parser.program();
        try {
            PrintWriter writer = new PrintWriter("parseTree.pt", "UTF-8");
            writer.println(tree);
            writer.println(tree.toStringTree(parser));
            writer.close();
        } catch (Exception e) {
            System.out.println("Unable to create parseTree " + e.getMessage());
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        infinityBaseListener extractor = new infinityBaseListener();
        walker.walk(extractor, tree);
        try {
            PrintWriter writer = new PrintWriter(args[0] + ".byte", "UTF-8");
            for (int i = 0; i < extractor.intermediate.size(); i++) {
                writer.println(extractor.intermediate.get(i));
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Unable lto create bytecode" + e.toString());
        }

        Loader loader = new Loader();
        loader.run(args[0] + ".byte");
    }
}
