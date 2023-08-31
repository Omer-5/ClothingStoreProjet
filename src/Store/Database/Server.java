package Store.Database;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;

public class Server {
    public static void main(String[] args)  throws IOException{
        try (ServerSocket server = new ServerSocket(7000)) {
            System.out.println(new Date() + " --> Server waits for clients ....");

            while(true)
            {
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run()
                    {
                        SocketData currentSocketData = new SocketData(socket);
                        System.out.println(new Date() + " --> Client connected from "+ currentSocketData.getClientAddress());

                        // Connected - Main Logic
                        try {
                            currentSocketData.getOutputStream().writeUTF("Welcome");
                        }catch (Exception e){
                            System.out.println("error");
                        }
                        
                    }
                }).start();
            }
        } catch ( IOException e)
        { // Can't Create server
            e.printStackTrace();
        }
    }
}
