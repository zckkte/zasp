
public class Pair implements IExpression {
    private Object first;
    private Object rest;

    public Pair (Object first, Object rest) {
        this.first = first;
        this.rest = rest;
    }

    public Object getFirst() {
        return this.first;
    }

    public Object getRest() {
        return this.rest;
    }

    public Object evaluate(ContextEnvironment environment) {
        IFunction function = (IFunction) Interpreter.evaluate(this.first,
                environment);
        if (function == null) {
            throw new UnsupportedOperationException();
        }

        return function.apply((Pair) this.rest, environment);
    }
}
