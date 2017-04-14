
public abstract class ListFunction implements IFunction {

    public abstract Object execute(Pair arguments, ContextEnvironment environment);

    @Override
    public Object apply(Pair arguments, ContextEnvironment environment) {
        return this.execute(evaluate(arguments, environment), environment);
    }

    private static Pair evaluate(Pair arguments, ContextEnvironment environment) {
        if (arguments == null) return null;

        return new Pair (Interpreter.evaluate(arguments.getFirst(), environment),
                evaluate((Pair) arguments.getRest(), environment));
    }
}