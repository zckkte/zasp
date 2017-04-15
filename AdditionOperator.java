
public class AdditionOperator extends ListFunction {

    //TODO: make generic
    @Override
    public Object execute(Pair arguments, ContextEnvironment environment) {
        double result = 0.0;
        while (arguments != null) {
            result += (double) arguments.getFirst();
            arguments = (Pair) arguments.getRest();
        }

        return result;
    }
}