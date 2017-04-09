import java.util.*;

public class ParserTest {
    public static void main(String[] args) {
        List<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token(TokenType.LeftParenthese, "("));
        tokens.add(new Token(TokenType.Name, "define"));
        tokens.add(new Token(TokenType.String, "p"));
        tokens.add(new Token(TokenType.Name, "("));
        tokens.add(new Token(TokenType.Number, 1.0));
        tokens.add(new Token(TokenType.Number, 2.0));
        tokens.add(new Token(TokenType.RightParenthese, ")"));
        tokens.add(new Token(TokenType.RightParenthese, ")"));

        Parser parser = new Parser(new Lexer(tokens));
        try { 
            Object expr = parser.parse();
            System.out.println(expr.toString());
        } catch (ParserException ex) {
            ex.printStackTrace();
        }
    }
}
