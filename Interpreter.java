
public class Interpreter {
    public ContextEnvironment environment;

    public Interpreter() {
        this.environment = new ContextEnvironment();
        initialise(this.environment);
    }

    public Object evaluate(Object value) {
        return evaluate(value, this.environment);
    }

    public static Object evaluate(Object value, ContextEnvironment environment) {
        if (value instanceof IExpression) {
            return ((IExpression) value).evaluate(environment);
        }

        return value;
    }

    public void initialise(ContextEnvironment environment) {
        /*
        environment.define("define", new PrimitiveDefine());
        environment.define("+", new PrimitivePlus());
        environment.define("-", new PrimitiveDifference());
        environment.define("lambda", new PrimitiveLambda());
        */
    }
}
