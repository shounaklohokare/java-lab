import java.net.*;
import java.io.*;

class Server {

    public static void main(String[] args) throws IOException, UnknownHostException {

        ServerSocket serverSocket = new ServerSocket(50710);

        System.out.println("Server started, waiting for client....");

        Socket socket = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        String str = dataInputStream.readUTF();

        String out = isPalindrome(str) ? (str + " is a palindrome.") : (str + " is NOT a palindrome.");

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(out);

        dataInputStream.close();
        dataOutputStream.close();
        socket.close();

    }

    static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        char[] ca = s.toCharArray();
        while (i < j) {
            if (ca[i++] != ca[j--])
                return false;
        }
        return true;

    }

}