import java.io.IOException;
import java.util.Scanner;

/**
 * Main Program. Includes main function.
 * Asks the User to be a client or Server
 * Created by Yohan on 3/25/2017.
 */
public class mainProgram {

    public static void main(String[] args) {

        //Input
        Scanner userInput = new Scanner(System.in);
        System.out.print("Server or Client? (1/2): "); int theInput = userInput.nextInt();

        if(theInput == 1) { //Server
            int port = 2302;
            Thread t = new iServer(port);
            t.start();
        }else if(theInput == 2) { //Client
            iClient client = new iClient(2302);
        }
    }
}
