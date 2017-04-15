import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interpreter {
    public static final String Prompt = "zasp> ";
    public ContextEnvironment environment;

    public Interpreter() {
        this.environment = new ContextEnvironment();
        this.initialise(this.environment);
    }

    public void run() {
        while (true) {
            System.out.print(Interpreter.Prompt);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                Parser parser = new Parser(new Lexer(reader));
                Object symbolicExpression = parser.parse();
                Object result = this.evaluate(symbolicExpression);
                System.out.println(result.toString());
            } catch (IOException | ParserException ex) {
                ex.printStackTrace();
                return;
            }
        }
    }

    public Object evaluate(Object value) {
        return this.evaluate(value, this.environment);
    }

    public static Object evaluate(Object value, ContextEnvironment environment) {
        if (value instanceof IExpression) return ((IExpression) value).evaluate(environment);
        return value;
    }

    public void initialise(ContextEnvironment environment) {
        environment.define("+", new AdditionOperator());
    }

}
