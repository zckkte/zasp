import java.util.*;

public class ContextEnvironment {
    private Map<String, Object> symbols;
    private ContextEnvironment parent;

    public ContextEnvironment() {
        this.symbols = new HashMap<String, Object>();
        this.parent = null;
    }

    public ContextEnvironment(ContextEnvironment parent) {
        this.symbols = new HashMap<String, Object>();
        this.parent = parent;
    }

    public void define(String name, Object value) {
        this.symbols.put(name, value);
    }

    public Object fetch(String name) {
        if (this.symbols.containsKey(name) && this.parent != null)
            return this.parent.fetch(name);

        return this.symbols.get(name);
    }

    public void defineGlobal(String name, Object value) {
        if (this.parent == null) {
            this.symbols.put(name, value);
        }

        this.parent.defineGlobal(name, value);
    }
}

