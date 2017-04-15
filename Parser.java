import java.io.IOException;

public class Parser {
    private Lexer lexer;

    public Parser (Lexer lexer) {
        this.lexer = lexer;
    }

    public Pair parseExpressionList() throws ParserException, IOException {
        if (this.lexer.peek().type == TokenType.RightParenthesis) return null;

        return new Pair(this.parseTerminal(), this.parseExpressionList());
    }

    public Object parseTerminal() throws ParserException, IOException {
        Token token = this.lexer.next();
        switch (token.type) {
            case TokenType.Number:
            case TokenType.String: return token.value;
            case TokenType.Name: return new Identifier((String) token.value);
            case TokenType.LeftParenthesis: return this.parseExpressionList();
            default: throw new ParserException("Unexcepted token '" + token.value + "'");
        }
    }

    public Object parse() throws ParserException, IOException {
        return this.parseTerminal();
    }
}

