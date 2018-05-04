package compiler;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import runtime.Loader;

import java.io.FileInputStream;
import java.io.PrintWriter;


public class infiCompiler {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);
        ANTLRInputStream input = new ANTLRInputStream(fis);

        infiLexer lexer = new infiLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        infiParser parser = new infiParser(tokens);
        ParserRuleContext tree = parser.program();

        /*Duplicate code just to showcase the compiler without Runtime*/

        try {
            PrintWriter writer = new PrintWriter("parseTree.pt", "UTF-8");
            writer.println(tree);
            writer.println(tree.toStringTree(parser));
            writer.close();
        } catch (Exception e) {
            System.out.println("Unable to create parseTree " + e.getMessage());
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        infiBaseListener extractor = new infiBaseListener();
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
    }
}

