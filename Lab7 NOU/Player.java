import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends Thread { //am ales sa mostenesc din Thread pentru a avea acces la vectorul de tokeni al fiecarui jucator
    String name;
    private List<Token> tokenList;
    //private int playerID;

    public Player(String name, int playerID) {
        this.name = name;
        //this.playerID = playerID;
        tokenList = new ArrayList<>();
    }

    public synchronized void pickToken() { //fara keywordul synchronized se vor alege de 2 ori unele tokenuri
        this.tokenList.add(Board.boardTokenList.get(0));
        Board.boardTokenList.remove(0);
        System.out.println(name + " a extras tokenul " + Board.boardTokenList.get(0).getValue());
    }


    @Override
    public void run() {
            while (Board.boardTokenList.size() > 1) {
                this.pickToken();
                    /*while (this.playerID != Game.currentPlayerID) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    this.pickToken();
                   Game.currentPlayerID = Game.currentPlayerID + 1;
                   notifyAll();*/
            }
    }
    public List<Token> getTokenList() {
        return tokenList;
    }
}