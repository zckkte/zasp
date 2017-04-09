
public class Identifier implements IExpression {
    private String name;

    public Identifier(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public Object evaluate(ContextEnvironment environment) {
        return environment.fetch(this.name);
    }
}
