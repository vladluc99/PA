import java.util.List;

public class Game {
    static boolean gameIsRunning;

    public Game() throws InterruptedException {
        gameIsRunning=true;
        Thread p1 = new Thread(new Player("Player 1"));
        Thread p2 = new Thread(new Player("Player 2"));
        p1.start();
        p2.start();

        p1.join();
        p2.join();


    }

}
