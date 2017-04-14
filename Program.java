import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        Interpreter interpreter = new Interpreter();
        while (true) {
            try (BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in)))
            {
                Parser parser = new Parser(new Lexer(reader.readLine()));

                try {
                    Object symbolicExpression = parser.parse();
                    Object result = interpreter.evaluate(symbolicExpression);
                    System.out.println(result.toString());
                } catch (ParserException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
