import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        Interpreter interpreter = new Interpreter();
        while (true) {
            try (BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in)))
            {
                Parser parser = new Parser(new Lexer(reader.readLine()));
                Object symbolicExpression = parser.parse();
                String result = interpreter.evaluate(symbolicExpression).toString();
                System.out.println(result);
            }
        }
    }
}
