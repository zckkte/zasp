import java.io.*;

public class Program {
    public static void main(String[] args) {
        try {
            Interpreter interpreter = new Interpreter();
            interpreter.run();
        } catch (IOException | ParserException e) {
            e.printStackTrace();
            return;
        }
    }
}
