import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String serverAddress = "127.0.0.1";
        int PORT = 8100;

        try {
            Socket socket = new Socket(serverAddress, PORT);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //String request = "World";
            /*System.out.print(">");
            String request = keyboard.next();
            out.println(request);
            String response = in.readLine();
            System.out.println(response);*/
            while(true){
                System.out.print(">");
                String reply = keyboard.next();
                out.println(reply);
                if(reply.equals("stop")){
                    System.out.println("Se inchide conexiunea...");
                    System.exit(0);
                }
                if(reply.equals("stop-server")){
                    System.out.println("Se inchide serverul...");
                    System.exit(0);
                }
                String message = in.readLine();
                System.out.println(message);

            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
