import java.net.*;
import java.io.*;

class Server {

	public static void main(String[] args) throws IOException, UnknownHostException {

		ServerSocket serverSocket = new ServerSocket(50710);

		System.out.println("Waiting for client....");

		Socket socket = serverSocket.accept();
		System.out.println("Client connected....");
		System.out.println("Server closed....");

		socket.close();
	}

}