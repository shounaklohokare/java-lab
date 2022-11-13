import java.net.*;
import java.io.*;
import java.util.*;

class ServerMachine {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(50710);

        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();

        Date date = new Date();

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        dos.writeUTF("Date and Time is " + date.toString());

        dos.close();
        socket.close();

    }

}