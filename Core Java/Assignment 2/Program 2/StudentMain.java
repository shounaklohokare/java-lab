import MScCAI.MScCAIMarks;
import MScCAII.MScCAIIMarks;

import java.io.*;

class Student {

    int rollNumber;
    String name;
    MScCAIMarks fy;
    MScCAIIMarks sy;

    static int currRollNum = 1;

    Student(String name, MScCAIMarks fy, MScCAIIMarks sy) {
        this.rollNumber = currRollNum++;
        this.name = name;
        this.fy = fy;
        this.sy = sy;
    }

    static Student[] getInput(int n) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            System.out.printf("\nStudent---->%d", i + 1);
            System.out.print("\nEnter the name of the student: ");
            String name = br.readLine();

            System.out.print("\nEnter the marks of MScCAI: semI: ");
            int fySemI = getMarks();

            System.out.print("\nEnter the marks of MScCAI: semII: ");
            int fySemII = getMarks();

            System.out.print("\nEnter the marks of MScCAII: semI: ");
            int sySemI = getMarks();

            System.out.print("\nEnter the marks of MScCAII: semII: ");
            int sySemII = getMarks();

            MScCAIMarks fy = new MScCAIMarks(fySemI, fySemII);
            MScCAIIMarks sy = new MScCAIIMarks(sySemI, sySemII);

            students[i] = new Student(name, fy, sy);

        }

        return students;

    }

    private static int getMarks() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mks;

        while (true) {

            mks = Integer.parseInt(br.readLine());

            if (mks >= 0 && mks <= 100)
                return mks;

            System.out.println(">Invalid input: Marks should be greater than equal to zero or less than hundred.");

        }

    }

    static void displayStudents(Student[] students) {

        for (int i = 0; i < students.length; i++) {

            System.out.printf("Student--->%d", i + 1);

            System.out.printf("\nRoll Number:- %d", students[i].rollNumber);
            System.out.printf("\nName:- %s", students[i].name);

            int MScCAIMarks = students[i].fy.returnTotal();
            System.out.printf("\nMScCAI marks:- %d", MScCAIMarks);

            int MScCAIIMarks = students[i].sy.returnTotal();
            System.out.printf("\nMScCAII marks:- %d", MScCAIIMarks);

            System.out.printf("\noverall total marks:- %d", MScCAIIMarks);
            int overallTotal = (MScCAIMarks + MScCAIIMarks) / 2;

            String grade;

            if (overallTotal >= 70)
                grade = "A";
            else if (overallTotal >= 60)
                grade = "B";
            else if (overallTotal >= 50)
                grade = "C";
            else if (overallTotal >= 40)
                grade = "Pass";
            else
                grade = "FAIL";

            System.out.printf("\nGrade:- %s", grade);
            System.out.println("\n");
        }

    }

}

class StudentMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter the number of student you want: ");
        int n = Integer.parseInt(br.readLine());

        Student[] students;

        students = Student.getInput(n);

        Student.displayStudents(students);

    }

}