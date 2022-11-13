import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException, UnknownHostException {

        Socket socket = new Socket("localhost", 50710);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter a string: ");
        String x = br.readLine();

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(x);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        System.out.println(dataInputStream.readUTF());

        dataInputStream.close();
        dataOutputStream.close();
        socket.close();

    }

}
