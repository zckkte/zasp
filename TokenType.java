import java.io.StreamTokenizer;

public final class TokenType {
    public final static int Number = StreamTokenizer.TT_NUMBER;
    public final static int String = '"';
    public final static int Name = StreamTokenizer.TT_WORD;
    public final static int Whitespace = ' ';
    public final static int EndOfLine = StreamTokenizer.TT_EOL;
    public final static int EndOfFile = StreamTokenizer.TT_EOF;
    public final static int Quote = '\'';
    public final static int LeftParenthesis = '(';
    public final static int RightParenthesis = ')';
}

