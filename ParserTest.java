import java.util.*;

public class ParserTest {
    public static void main(String[] args) {
        List<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token(TokenType.LeftParenthese, "("));
        tokens.add(new Token(TokenType.Name, "+"));
        tokens.add(new Token(TokenType.Number, 1.0));
        tokens.add(new Token(TokenType.Number, 2.0));
        tokens.add(new Token(TokenType.RightParenthese, ")"));

        Interpreter interpreter = new Interpreter();
        Parser parser = new Parser(new Lexer(tokens));
        try { 
            Object expr = parser.parse();
            Object result = interpreter.evaluate(expr);
            System.out.println(result.toString());
        } catch (ParserException ex) {
            ex.printStackTrace();
        }
    }
}
