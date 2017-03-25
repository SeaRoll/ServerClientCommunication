import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * The Server Class.
 * Handles new connections.
 * Created by Yohan on 3/25/2017.
 */
public class iServer extends Thread {

    //ServerSocket and ArrayList to make it dynamic
    private ServerSocket serverSocket;
    public ArrayList<iSocket> sockets = new ArrayList();

    public iServer(int port) {
        Socket socket = null;

        //Listen
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Check for a connection
        while (true) {
            try {
                socket = serverSocket.accept();


            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            //Add the client socket to ArrayList
            sockets.add( new iSocket(socket));
            sockets.get(sockets.size() - 1).start();
        }
    }
}
