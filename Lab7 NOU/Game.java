import java.util.Collections;
import java.util.List;

public class Game {
    //static boolean gameIsRunning;

    static int currentPlayerID;
    public Game() throws InterruptedException {
        //gameIsRunning=true;
        currentPlayerID=1;
        Player p1 = new Player("Player 1",1);
        Player p2 = new Player("Player 2",2);
        p1.start();
        p2.start();

        p1.join();
        p2.join();

        if(getProgression(p1.getTokenList())==getProgression(p2.getTokenList())){
            System.out.println("EGALITATE");
        }
        else if (getProgression(p1.getTokenList())>getProgression(p2.getTokenList())){
            System.out.println("Player 1 castiga cu o progresie de "+ getProgression(p1.getTokenList())+ " numere" );
        }
        else
            System.out.println("Player 2 castiga cu o progresie de "+ getProgression(p2.getTokenList())+ " numere" );


    }
    public int getProgression (List<Token> tokenList){
        tokenList.sort(new tokenComparator());
        int r;
        int maxP=0;
        int currP=1;
        r=tokenList.get(1).getValue()-tokenList.get(0).getValue();
        for(int i=2;i<tokenList.size();i++){
            if(tokenList.get(i).getValue()-tokenList.get(i-1).getValue()==r){
                currP++;
                if(currP>maxP)
                    maxP=currP;
            }
            else
            {
                r=tokenList.get(i).getValue()-tokenList.get(i-1).getValue();
                currP=1;
            }
        }
        return maxP;
    }

}