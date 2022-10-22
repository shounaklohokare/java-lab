import java.net.*;
import java.io.*;

class Server {

    public static void main(String[] args) throws IOException, UnknownHostException {

        ServerSocket serverSocket = new ServerSocket(50710);

        System.out.println("Server started, Waiting for client.....");

        Socket socket = serverSocket.accept();
        System.out.println("Connected to client");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String input;
        while ((input = br.readLine()) != null) {
            System.out.println(input);
        }
        System.out.println("Server Closed");
        socket.close();
    }

}