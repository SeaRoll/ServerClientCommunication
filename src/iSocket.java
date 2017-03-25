import java.io.*;
import java.net.Socket;

/**
 * client socket. handles all things between client and server
 * Created by Yohan on 3/25/2017.
 */
public class iSocket extends Thread {
    protected Socket socket;
    boolean connected = true;

    public iSocket(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        while(connected) { //Check if client is connected to server
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                //Update client by sending a message
                //Read Messages
                while(true){
                    System.out.println(in.readUTF());
                    out.writeUTF("");
                }
            } catch (IOException e) {
                connected = false;
            }
        }
        System.out.println("Connection closed");
    }

    public void sendMessage(String msg) { //Function for sending messages to client
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
