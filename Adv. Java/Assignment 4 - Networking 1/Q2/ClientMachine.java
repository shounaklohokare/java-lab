import java.net.*;
import java.io.*;

class ClientMachine {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 50710);

        System.out.println("Connected to Client...");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println(br.readLine());

        socket.close();

    }

}