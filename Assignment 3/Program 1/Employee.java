import java.io.*;

class Employee {

    private int id;
    private String name;
    private String department;
    protected float salary;

    private static int currentId = 1;

    Employee() {
        this("", "", 0);
    }

    Employee(String name, String department, float salary) {
        this.id = Employee.currentId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public static Employee[] accept(int n) throws IOException {

        Employee[] employees = new Employee[n];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {

            System.out.print("Employee--->" + i + 1);

            System.out.print("\nEnter the name of the employee: ");
            String name = br.readLine();

            System.out.print("\nEnter the department of the employee: ");
            String department = br.readLine();

            System.out.print("\nEnter the salary of the employee: ");
            float salary;
            while (true) {
                salary = Float.parseFloat(br.readLine());

                if (salary > 0)
                    break;
                System.out.print("\nSalary should be greater than zero: ");
            }

            employees[i] = new Employee(name, department, salary);

        }

        return employees;

    }

    public static void display(Employee[] employees) {

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

    }

    public String toString() {
        return "Id:- " + this.id + "\nName:- " + this.name + "\nDepartment:- " + this.department + "\nSalary:- "
                + this.salary;
    }

}

class Manager extends Employee {

    private final static float bonus = 0.3f;

    private float totalSalary;

    Manager() {
        this("", "", 0.0f);
    }

    Manager(String name, String department, float salary) {
        super(name, department, salary);
        this.totalSalary = ((salary * Manager.bonus) + salary);
    }

    public static Manager[] accept(int n) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Manager[] managers = new Manager[n];

        System.out.println("\n______INPUT DETAILS_______");
        for (int i = 0; i < n; i++) {

            System.out.print("\n\nEmployee--->" + (i + 1));

            System.out.print("\nEnter the name of the employee: ");
            String name = br.readLine();

            System.out.print("\nEnter the department of the employee: ");
            String department = br.readLine();

            System.out.print("\nEnter the salary of the employee: ");
            float salary;
            while (true) {
                salary = Float.parseFloat(br.readLine());

                if (salary > 0)
                    break;
                System.out.print("\nSalary should be greater than zero, Please enter again: ");
            }

            managers[i] = new Manager(name, department, salary);

        }

        return managers;

    }

    public String toString() {
        return "\n" + super.toString() + "\nOverall salary:- " + this.totalSalary + "\n";
    }

    public static void display(Manager[] managers) {

        for (int i = 0; i < managers.length; i++) {
            System.out.println(managers[i]);
        }

    }

    public static void displayMaxSalary(Manager[] managers) {

        float max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < managers.length; i++) {
            if (managers[i].totalSalary > max) {
                max = managers[i].totalSalary;
                index = i;
            }
        }

        System.out.println("The maximum salary is of Employee: " + managers[index]);

    }

}

class EmployeeMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter the number of employees: ");
        int n = Integer.parseInt(br.readLine());

        Manager[] managers;

        managers = Manager.accept(n);

        Manager.display(managers);

        Manager.displayMaxSalary(managers);

    }

}