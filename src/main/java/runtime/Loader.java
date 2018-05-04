package runtime;

import runtime.ds.SymbolTable;
import runtime.ds.Stack;
import runtime.runtime.Runtime;
import runtime.utility.In;


public class Loader {

    public void run(String filepath) {
        In in = new In(filepath);

        String[] strings = in.readAllLines();

        Stack<String> stack = new Stack<>();
        SymbolTable<String, String> env = new SymbolTable<>();

        Runtime runtime = new Runtime();
        int eip = 0;
        while(eip < strings.length) {
            String command = strings[eip];
            String[] tokens = command.split("\\s+");

            eip = runtime.process(tokens, stack, env, eip);
        }
        in.close();
    }

    public static void main(String[] args) {
        Loader infinityLoader = new Loader();
        infinityLoader.run(args[0]);
    }

}
