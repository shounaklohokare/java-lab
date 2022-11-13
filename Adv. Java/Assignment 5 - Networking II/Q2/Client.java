import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 50710);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = br.readLine();

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(fileName);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        System.out.println(dataInputStream.readUTF());

        dataOutputStream.close();
        dataInputStream.close();
        socket.close();
    }

}
