
public class Interpreter {
    public ContextEnvironment environment;

    public Interpreter() {
        this.environment = new ContextEnvironment();
        this.initialise(this.environment);
    }

    public Object evaluate(Object value) {
        return this.evaluate(value, this.environment);
    }

    public static Object evaluate(Object value, ContextEnvironment environment) {
        if (value instanceof IExpression) {
            return ((IExpression) value).evaluate(environment);
        }

        return value;
    }

    public void initialise(ContextEnvironment environment) {
        environment.define("+", new AdditionOperator());
    }
}
