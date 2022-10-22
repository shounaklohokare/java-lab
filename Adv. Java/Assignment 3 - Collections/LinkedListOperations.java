import java.io.*;
import java.util.*;

class LinkedListOperations {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter how many elements you want to add in the 1st LinkedList: ");
        int n1 = Integer.parseInt(br.readLine());
        System.out.println("Enter elements in 1st LinkedList: ");
        for (int i = 0; i < n1; i++) {
            int x = Integer.parseInt(br.readLine());
            if (!l1.contains(x))
                l1.add(x);
        }

        System.out.println("______1st LinkedList______");
        System.out.println("1st LinkedList elements are: " + l1);
        System.out.print("\nEnter how many elements you want to add in the 2nd LinkedList: ");
        int n2 = Integer.parseInt(br.readLine());

        System.out.println("Enter elements in 2nd LinkedList: ");
        for (int i = 0; i < n2; i++) {
            int x = Integer.parseInt(br.readLine());
            if (!l2.contains(x))
                l2.add(x);
        }
        System.out.println("______2nd LinkedList______");
        System.out.println("2nd LinkedList elements are: " + l2);

        int c;

        while (true) {
            System.out.println("\n______MAIN MENU______");
            System.out.println("1.Display both list in the reverse order");
            System.out.println("2.Display intersection of two list");
            System.out.println("3.Add element at first position in 1st LinkedList");
            System.out.println("4.Remove the last element from 2nd LinkedList");
            System.out.println("5.Exit");
            System.out.println("________________________");

            System.out.print("\nEnter your choice: ");

            c = Integer.parseInt(br.readLine());

            switch (c) {
                case 1:
                    ArrayList<Integer> list1 = new ArrayList<>(l1);
                    ArrayList<Integer> list2 = new ArrayList<>(l2);
                    Collections.reverse(list1);
                    Collections.reverse(list2);

                    System.out.println("Reversed elements of 1st LinkedList are: " + list1);
                    System.out.println("Reversed elemnts of 2nd LinkedList are:" + list2);

                    break;

                case 2:
                    l1.retainAll(l2);
                    if (l1.size() == 0) {
                        System.out.println(
                                "There are no common elements in the two LinkedLists, therefore intersection set is empty.");
                        break;
                    }
                    System.out.println("Intersection of two LinkedList is: " + l1);
                    break;

                case 3:
                    System.out.print("\nEnter the element: ");
                    int el = Integer.parseInt(br.readLine());
                    l1.addFirst(el);
                    System.out.println("After adding element at first position of 1st LinkedList :-" + l1);
                    break;

                case 4:
                    l2.removeLast();
                    System.out.println("After removing last element from 2nd LinkedList: " + l2);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
}