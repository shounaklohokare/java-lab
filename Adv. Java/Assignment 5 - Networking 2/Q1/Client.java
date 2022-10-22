import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException, UnknownHostException {

        Socket socket = new Socket("localhost", 50710);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintStream printStream = new PrintStream(socket.getOutputStream());

        System.out.println("Enter the message: ");
        String x;
        while (true) {
            x = br.readLine();
            printStream.println(x);

            if (x.equalsIgnoreCase("end")) {
                break;
            }
        }
        System.out.println("Client Closed");
        printStream.close();
        socket.close();

    }

}
