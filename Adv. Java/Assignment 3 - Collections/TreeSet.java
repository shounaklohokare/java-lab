import java.util.*;
import java.io.*;

class TreeSet {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter how many colors you want to add: ");
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> ts = new TreeSet<>();

        System.out.println("\nEnter the names of colors: ");
        for (int i = 0; i < n; i++) {
            ts.add(br.readLine());
        }

        Iterator iteratorVal = ts.iterator();

        System.out.println("----------------");
        System.out.println("Sorted values are: ");

        while (iteratorVal.hasNext()) {
            System.out.println(iteratorVal.next());
        }
    }
}