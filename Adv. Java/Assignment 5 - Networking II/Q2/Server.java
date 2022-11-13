import java.net.*;
import java.io.*;
import java.util.*;

class Server {

    public static void main(String[] args) throws IOException, UnknownHostException {

        ServerSocket serverSocket = new ServerSocket(50710);

        System.out.println("Server started. Waiting for client.....");

        Socket socket = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String fileName = dataInputStream.readUTF();

        if (!fileName.endsWith(".txt")) {
            dataOutputStream.writeUTF("Error :- Unknown file entered, Enter a valid txt file.");
            System.exit(0);
        }

        StringBuffer sbf = new StringBuffer();
        try {

            File f = new File(fileName);

            Scanner sc = new Scanner(f);

            while (sc.hasNext()) {
                sbf.append(sc.next());
                sbf.append("\n");
            }

            dataOutputStream.writeUTF(sbf.toString());

        } catch (FileNotFoundException fnfe) {
            dataOutputStream.writeUTF("File not found!!");
        }
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();

    }

}