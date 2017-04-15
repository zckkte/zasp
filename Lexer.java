import java.io.*;

public class Lexer {
    private StreamTokenizer streamTokenizer;

    public Lexer(String input) {
        this(new BufferedReader(new StringReader(input)));
    }

    public Lexer(BufferedReader bufferedReader) {
        this.streamTokenizer = new StreamTokenizer(bufferedReader);
        this.streamTokenizer.resetSyntax();
        this.streamTokenizer.parseNumbers();
        this.streamTokenizer.whitespaceChars(0, TokenType.Whitespace);
        this.streamTokenizer.wordChars(TokenType.Whitespace + 1,255);
        this.streamTokenizer.ordinaryChar(TokenType.LeftParenthesis);
        this.streamTokenizer.ordinaryChar(TokenType.RightParenthesis);
        this.streamTokenizer.quoteChar(TokenType.String);
    }

    public Token next() throws IOException {
        this.streamTokenizer.nextToken();
        return new Token(this.streamTokenizer);
    }

    public Token peek() throws IOException {
        this.streamTokenizer.nextToken();
        if (this.streamTokenizer.ttype == StreamTokenizer.TT_EOF) return null;

        Token token = new Token(this.streamTokenizer);
        this.streamTokenizer.pushBack();
        return token;
    }
}
