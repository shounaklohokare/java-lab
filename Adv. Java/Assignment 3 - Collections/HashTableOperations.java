import java.io.*;
import java.util.*;

class HashTableOperations {
    public static void main(String args[]) throws IOException {
        Hashtable<String, Double> h1 = new Hashtable<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter how many students you want to add: ");
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("\nEnter name of the Student %d: ", (i + 1));
            String key = br.readLine();

            while (true) {
                System.out.printf("\nEnter percentage of Student %d: ", (i + 1));
                double value = Double.parseDouble(br.readLine());

                if (value > 0.0 && value < 100.00) {
                    h1.put(key, value);
                    break;
                }
                System.out.println("Percentage should be greater than 0 and less than 100.");

            }
        }

        System.out.println("Contents of table: " + h1);

        System.out.print("\nEnter the Student name you want to search: ");
        String name = br.readLine();

        if (h1.containsKey(name)) {
            System.out.println("Percentage of " + name + " is: " + h1.get(name));
        } else {
            System.out.println("Student record not found");
        }
    }
}