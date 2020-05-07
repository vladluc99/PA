import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;


    public ClientThread(Socket socket) {

        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //String request = in.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //String raspuns = "Hello " + request + "!";
            //out.println(raspuns);
            //out.flush();
            while (GameServer.serverRunning) {
                String message = in.readLine();
                if(message.equals("stop")) {
                    break;
                }
                else if(message.equals("stop-server")){
                    GameServer.serverRunning = false;
                    System.exit(0);
                    break;
                }
                else{
                    String raspuns = "Hello " + message;
                    out.println(raspuns);
                    out.flush();
                }
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
