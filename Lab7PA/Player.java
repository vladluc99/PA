import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    String name;
    private List<Token> tokenList;

    public Player(String name) {
        this.name = name;
        tokenList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public synchronized void pickToken() { //fara keywordul synchronized se vor alege de 2 ori unele tokenuri
            this.tokenList.add(Board.boardTokenList.get(0));
            Board.boardTokenList.remove(0);
            System.out.println(name + " a extras tokenul " + Board.boardTokenList.get(0).getValue());

    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    @Override
    public void run() {
        while (Board.boardTokenList.size()>1) {
            this.pickToken();
        }
    }
}
