import java.util.*;

public class Lexer {
    public String input;
    public List<Token> tokens;
    public static final int FIRST = 0;

    public Lexer(String input) {
        this.input = input;
    }

    public Lexer(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Token Next() {
        return this.tokens.remove(FIRST);
    }

    public Token Peek() {
        return this.tokens.get(FIRST);
    }
}
