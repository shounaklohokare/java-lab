import java.io.*;
import java.util.*;

class ListOperations extends ArrayList<Integer> {

    public static ArrayList<Integer> al = new ArrayList<Integer>();
    public static LinkedList<Integer> ll = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.println("\n___MAIN MENU___");
            System.out.println("1. Array List");
            System.out.println("2. Linked List");
            System.out.println("3. Exit");

            System.out.print("\nEnter your option:- ");
            int op = Integer.parseInt(br.readLine());

            switch (op) {

                case 1:
                    int alop = -1;
                    while (alop != 8) {
                        System.out.println("\n____ArrayList Menu______");
                        showMenu();

                        System.out.print("\nEnter your option:- ");
                        alop = Integer.parseInt(br.readLine());

                        switch (alop) {

                            case 1:
                                System.out.print("\nEnter an element: ");
                                int e = Integer.parseInt(br.readLine());

                                al.add(e);
                                break;

                            case 2:
                                int idx = getIndex(true);

                                System.out.print("\nEnter an element: ");
                                e = Integer.parseInt(br.readLine());

                                al.add(idx, e);
                                break;

                            case 3:
                                int n;
                                while (true) {

                                    System.out.print("\nEnter number of elements: ");
                                    n = Integer.parseInt(br.readLine());

                                    if (n > 0)
                                        break;

                                    System.out.println("Enter valid number of elements");

                                }
                                for (int i = 0; i < n; i++) {
                                    System.out.print("\nEnter the element:- ");
                                    al.add(Integer.parseInt(br.readLine()));
                                }
                                break;

                            case 4:
                                if (al.size() == 0) {
                                    System.out.println("ArrayList is empty cannot remove!");
                                    break;
                                }
                                idx = getIndex(true);
                                al.remove(idx);
                                break;

                            case 5:
                                if (al.size() == 0) {
                                    System.out.println("ArrayList is empty cannot remove!");
                                    break;
                                }
                                while (true) {
                                    System.out.print("\nEnter an element: ");
                                    e = Integer.parseInt(br.readLine());

                                    if (al.contains(e)) {
                                        break;
                                    }
                                    System.out.println(
                                            "Element does not exist! Please enter valid element from ArrayList:- "
                                                    + al);
                                }
                                al.remove(Integer.valueOf(e));
                                break;

                            case 6:
                                if (al.size() == 0) {
                                    System.out.println("ArrayList is empty cannot remove!");
                                    break;
                                }
                                if (al.size() == 1) {
                                    System.out.println("ArrayList has only one element, cannot remove in range!");
                                    break;
                                }

                                while (true) {

                                    System.out.print("\nEnter start index: ");
                                    idx = Integer.parseInt(br.readLine());

                                    if (idx >= 0 && idx < (al.size() - 1))
                                        break;

                                    System.out.println("Invalid Index! Please enter a valid index");

                                }
                                int edx;

                                while (true) {

                                    System.out.print("\nEnter end index: ");
                                    edx = Integer.parseInt(br.readLine());

                                    if (edx >= 0 && edx < al.size() && edx > idx)
                                        break;

                                    System.out.println("Invalid Index! Please enter a valid index");

                                }

                                // al.removeRange(idx, edx);

                                List<Integer> tal = new ArrayList<Integer>();
                                for (int i = idx; i <= edx; i++) {
                                    tal.add(al.get(i));
                                }

                                al.removeAll(tal);
                                break;

                            case 7:
                                System.out.println(al);
                                break;

                            case 8:
                                break;

                            default:
                                System.out.println("Please enter valid option!!");

                        }

                    }

                    break;

                case 2:
                    //
                    int llop = -1;
                    while (llop != 8) {
                        System.out.println("\n____LinkedList Menu______");
                        showMenu();
                        System.out.print("\nEnter your option:- ");
                        llop = Integer.parseInt(br.readLine());

                        switch (llop) {

                            case 1:
                                System.out.print("\nEnter an element: ");
                                int e = Integer.parseInt(br.readLine());

                                ll.add(e);
                                break;

                            case 2:
                                int idx = getIndex(false);

                                System.out.print("\nEnter an element: ");
                                e = Integer.parseInt(br.readLine());

                                ll.add(idx, e);
                                break;

                            case 3:
                                int n;
                                while (true) {

                                    System.out.print("\nEnter number of elements: ");
                                    n = Integer.parseInt(br.readLine());

                                    if (n > 0)
                                        break;

                                    System.out.println("Enter valid number of elements");

                                }
                                for (int i = 0; i < n; i++) {
                                    System.out.print("\nEnter the element:- ");
                                    ll.add(Integer.parseInt(br.readLine()));
                                }
                                break;

                            case 4:
                                if (ll.size() == 0) {
                                    System.out.println("LinkedList is empty cannot remove!");
                                    break;
                                }
                                idx = getIndex(false);
                                ll.remove(idx);
                                break;

                            case 5:
                                if (ll.size() == 0) {
                                    System.out.println("LinkedList is empty cannot remove!");
                                    break;
                                }
                                while (true) {
                                    System.out.print("\nEnter an element: ");
                                    e = Integer.parseInt(br.readLine());

                                    if (ll.contains(e)) {
                                        break;
                                    }
                                    System.out.println(
                                            "Element does not exist! Please enter valid element from ArrayList:- "
                                                    + ll);
                                }
                                ll.remove(Integer.valueOf(e));
                                break;

                            case 6:
                                if (ll.size() == 0) {
                                    System.out.println("LinkedList is empty cannot remove!");
                                    break;
                                }
                                if (ll.size() == 1) {
                                    System.out.println("LinkedList has only one element, cannot remove in range!");
                                    break;
                                }
                                while (true) {

                                    System.out.print("\nEnter start index: ");
                                    idx = Integer.parseInt(br.readLine());

                                    if (idx >= 0 && idx < (ll.size() - 1))
                                        break;

                                    System.out.println("Invalid Index! Please enter a valid index");

                                }

                                int edx;
                                while (true) {

                                    System.out.print("\nEnter end index: ");
                                    edx = Integer.parseInt(br.readLine());

                                    if (edx >= 0 && edx < ll.size() && edx > idx)
                                        break;

                                    System.out.println("Invalid Index! Please enter a valid index");

                                }

                                List<Integer> tal = new ArrayList<Integer>();
                                for (int i = idx; i <= edx; i++) {
                                    tal.add(ll.get(i));
                                }

                                ll.removeAll(tal);
                                break;

                            case 7:
                                System.out.println(ll);
                                break;

                            case 8:
                                break;

                            default:
                                System.out.println("Please enter valid option!!");

                        }

                    }

                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("You have entered incorrect option");
            }

        }

    }

    static int getIndex(boolean isArrayList) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx;
        while (true) {

            System.out.print("\nEnter an index: ");
            idx = Integer.parseInt(br.readLine());

            if (idx >= 0 && ((isArrayList && idx < al.size()) || (!isArrayList && idx < ll.size())))
                return idx;

            System.out.println("Invalid Index! Please enter a valid index");

        }
    }

    static void showMenu() {
        System.out.println("1. Insertion");
        System.out.println("2. Index based insertion");
        System.out.println("3. Multiple insertion");
        System.out.println("4. Index based removal");
        System.out.println("5. Value based removal");
        System.out.println("6. Range based removal");
        System.out.println("7. Display");
        System.out.println("8. Exit");
    }

}