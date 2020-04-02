import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    static List<Token> boardTokenList;
    private int m;

    public Board(int m) {
        this.m = m;

        boardTokenList=new ArrayList<>();
        Token[] tokens= new Token[m+1];
        for(int i=0;i<=m;i++)
        {
            tokens[i]= new Token(i);
        }
        boardTokenList.addAll( Arrays.asList(tokens) );
    }

}
