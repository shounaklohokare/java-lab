import java.io.*;

class Student {

    String name;
    float percentage;
    int roll_no;
    static int totalStudents = 0;

    static int[] roll_numbers;

    Student(int roll_no, String name, float percentage) {
        this.roll_no = roll_no;
        this.name = name;
        this.percentage = percentage;
        totalStudents++;
    }

    Student() {
        this(0, null, 0.0f);
    }

    public static Student[] getUserInput(int n) throws IOException {

        Student[] students = new Student[n];
        roll_numbers = new int[n];
        int rno;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {

            System.out.printf("\nStudent---> %d", i + 1);
            System.out.print("\nEnter the roll number: ");
            while (true) {

                rno = Integer.parseInt(br.readLine());

                if (rno > 0 && isUnique(rno)) {
                    roll_numbers[i] = rno;
                    break;
                } else {
                    System.out.println(">Invalid input. Roll number should be greater than zero and unique.");
                }

            }
            System.out.print("\nEnter the name: ");
            String name = br.readLine();

            System.out.print("\nEnter the percentage: ");
            float percentage;
            while (true) {

                percentage = Float.parseFloat(br.readLine());

                if (percentage <= 0) {
                    System.out.println(">Invalid Input. Percentage should be positve");
                } else
                    break;

            }

            students[i] = new Student(rno, name, percentage);

        }

        return students;
    }

    private static boolean isUnique(int rno) {

        for (int i = 0; i < roll_numbers.length; i++) {
            if (roll_numbers[i] == rno) {
                return false;
            }
        }
        return true;
    }

    public static void sortPercentage(Student[] students) {
        boolean didSwap;
        for (int i = 0; i < students.length; i++) {
            didSwap = false;
            for (int j = 1; j < students.length - i; j++) {
                if (students[j - 1].percentage < students[j].percentage) {
                    Student temp = students[j];
                    students[j] = students[j - 1];
                    students[j - 1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap)
                break;
        }

    }

    public String toString() {
        return "Roll number: " + this.roll_no + "\tName: " + this.name + "\tPercentage: " + this.percentage;
    }
}

class StudentMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter the number of students: ");
        int n = Integer.parseInt(br.readLine());

        Student[] students = Student.getUserInput(n);

        System.out.println("The students are: ");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        Student.sortPercentage(students);

        System.out.println("The students sorted by percentage are: ");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

    }

}