import java.io.*;
import java.net.Socket;

/**
 * Created by Yohan on 3/25/2017.
 */
public class iClient {
    private String serverName = "127.0.0.1"; //IP
    int port = 0; //PORT
    private Socket client;

    public iClient (int Port) {
        port = Port;

        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress()); //Send a hello message to server
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            while(true) { //Check 24/7 if server says something
                if(in.readUTF() != "") {
                    System.out.println("Server says " + in.readUTF());
                }
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
