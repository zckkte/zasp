
public class Parser {
    private Lexer lexer;

    public Parser (Lexer lexer) {
        this.lexer = lexer;
    }

    public Pair parseExpressionList() throws ParserException {
        Token token = this.lexer.Peek();
        if (token.Type == TokenType.RightParenthese) return null;

        return new Pair(this.parseTerminal(), this.parseExpressionList());
    }

    public Object parseTerminal() throws ParserException {
        Token token = this.lexer.Next();
        switch (token.Type) {
            case Number:
            case String:
                return token.Value;
            case Name:
                return new Identifier((String) token.Value);
            case LeftParenthese:
                return this.parseExpressionList();
            default: 
                throw new ParserException("Unexcepted token '"
                        + token.Value + "'");
        }
    }

    public Object parse() throws ParserException {
        return this.parseTerminal();
    }
}

