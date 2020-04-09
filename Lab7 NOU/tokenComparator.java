import java.util.Comparator;

public class tokenComparator implements Comparator<Token> {
    @Override
    public int compare(Token o1, Token o2) {
        return Integer.compare(o1.getValue(),o2.getValue());
    }
}
