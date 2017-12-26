import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interpreter {
    private static final String Prompt = "zasp> ";
    public ContextEnvironment environment;

    public Interpreter() {
        this.environment = new ContextEnvironment();
        this.initialise(this.environment);
    }

    public void run() throws IOException, ParserException{
        while (true) {
            System.out.print(Interpreter.Prompt);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Parser parser = new Parser(new Lexer(reader));
            Object symbolicExpression = parser.parse();
            Object result = this.evaluate(symbolicExpression);
            System.out.println(result.toString());
        }
    }

    public Object evaluate(Object value) {
        return evaluate(value, this.environment);
    }

    public static Object evaluate(Object value, ContextEnvironment environment) {
        if (value instanceof IExpression) return ((IExpression) value).evaluate(environment);
        return value;
    }

    public void initialise(ContextEnvironment environment) {
        environment.define("+", new AdditionOperator());
        /*
        environment.define("def", new DefineProcedure());
        environment.define("\\", new LambdaProcedure());
        environment.define("if", new ConditionalProcedure());
        environment.define("ls", new ListProcedure());
        */
    }

}
