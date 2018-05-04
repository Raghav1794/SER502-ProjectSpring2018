package runtime.ds;

import java.util.TreeMap;

public class SymbolTable<Key extends Comparable<Key>, Value> {

    private TreeMap<Key, Value> symTable;

    public SymbolTable() {
        symTable = new TreeMap<>();
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("called get() with null key");
        return symTable.get(key);
    }


    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("called put() with null key");
        if (val == null) symTable.remove(key);
        else             symTable.put(key, val);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("called contains() with null key");
        return symTable.containsKey(key);
    }
}
