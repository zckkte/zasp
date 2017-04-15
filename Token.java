import java.io.StreamTokenizer;

final class Token {
    public int type;
    public Object value;
    public int lineNumber;

    public Token(StreamTokenizer streamTokenizer) {
        this.type = streamTokenizer.ttype;
        this.lineNumber = streamTokenizer.lineno();
        this.value = this.type == TokenType.Number
                ? streamTokenizer.nval
                : streamTokenizer.sval;
    }

    public String toString() {
        switch(this.type) {
            case TokenType.Name:
            case TokenType.String:
            case TokenType.Number: return this.value.toString();
            default: return String.valueOf((char) this.type);
        }
    }
}
