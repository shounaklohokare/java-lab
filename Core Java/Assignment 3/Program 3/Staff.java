import java.io.*;

abstract class Staff {

    String name;
    String address;

    Staff() {
        this("", "");
    }

    Staff(String name, String address) {
        this.name = name;
        this.address = address;
    }

}

class FullTimeStaff extends Staff {

    String department;
    float salary;

    FullTimeStaff(String name, String address, String department, float salary) {
        this.name = name;
        this.address = address;
        this.department = department;
        this.salary = salary;
    }

    public static FullTimeStaff acceptInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\n____________FULL TIME STAFF INPUT____________");

        System.out.print("\nEnter the name of the staff: ");
        String name = br.readLine();

        System.out.print("\nEnter the address of the staff: ");
        String address = br.readLine();

        System.out.print("\nEnter the department of the staff: ");
        String department = br.readLine();

        System.out.print("\nEnter the salary of the staff: ");
        float salary;
        while (true) {

            salary = Float.parseFloat(br.readLine());

            if (salary > 0)
                break;

            System.out.print("Error: Salary should be greater than zero, please Enter again: ");

        }

        return new FullTimeStaff(name, address, department, salary);

    }

    public String toString() {
        return "\nName:- " + this.name + "\nAddress:- " + this.address + "\nDepartment:- " + this.department
                + "\nSalary:- " + this.salary;
    }

}

class PartTimeStaff extends Staff {

    float numberOfHours;
    float ratePerHour;

    PartTimeStaff() {
        this(null, null, 0.0f, 0.0f);
    }

    PartTimeStaff(String name, String department, float numberOfHours, float ratePerHour) {
        super(name, department);
        this.numberOfHours = numberOfHours;
        this.ratePerHour = ratePerHour;
    }

    public static PartTimeStaff acceptInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n__________PART TIME STAFF INPUT_________");

        System.out.print("\nEnter the name of the staff: ");
        String name = br.readLine();

        System.out.print("\nEnter the address of the staff: ");
        String address = br.readLine();

        System.out.print("\nEnter the number of hours the staff has worked: ");
        float numberOfHours;
        while (true) {

            numberOfHours = Float.parseFloat(br.readLine());

            if (numberOfHours > 0)
                break;

            System.out.print("Error: Number of hours should be greater than zero, please enter again: ");

        }

        System.out.print("\nEnter the rate per hour of the staff: ");
        float ratePerHour;
        while (true) {

            ratePerHour = Float.parseFloat(br.readLine());

            if (ratePerHour > 0)
                break;

            System.out.print("Error: Rate per hour should be greater than zero, please enter again: ");

        }

        return new PartTimeStaff(name, address, numberOfHours, ratePerHour);

    }

    public String toString() {
        return "\nName:- " + this.name + "\nAddress:- " + this.address + "\nNumber of houurs:- "
                + this.numberOfHours + "\nRate per hour:- " + this.ratePerHour;
    }

}

class StaffMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\n____________MAIN MENU________________");
        String choice = "";
        while (!choice.equals("3")) {

            System.out.print("\n1. Full Time Staff");
            System.out.print("\n2. Part Time Staff");
            System.out.print("\n3. Exit");

            System.out.print("\nEnter your choice: ");
            choice = br.readLine();

            switch (choice) {

                case "1":
                    System.out.print("\nYou have selected:- Full Time Staff");

                    System.out.print("\nEnter the number of full time staff you want:- ");
                    int n = Integer.parseInt(br.readLine());

                    FullTimeStaff[] fullTime = new FullTimeStaff[n];

                    for (int i = 0; i < fullTime.length; i++) {
                        fullTime[i] = FullTimeStaff.acceptInput();
                    }

                    for (int i = 0; i < fullTime.length; i++) {
                        System.out.println(fullTime[i]);
                    }

                    break;

                case "2":
                    System.out.print("\nYou have selected:- Part Time Staff");

                    System.out.print("\nEnter the number of part time staff you want:- ");
                    int m = Integer.parseInt(br.readLine());

                    PartTimeStaff[] partTime = new PartTimeStaff[m];

                    for (int i = 0; i < partTime.length; i++) {
                        partTime[i] = PartTimeStaff.acceptInput();
                    }

                    for (int i = 0; i < partTime.length; i++) {
                        System.out.println(partTime[i]);
                    }

                    break;

                case "3":
                    break;

                default:
                    System.out.println("Error: Invalid Input: Please select appropriate from the menu");
                    break;

            }

        }

    }

}