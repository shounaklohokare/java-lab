import java.io.*;
import Employee;

public class EmployeeMain {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("\nEnter the number of employees you want: ");
		int n = Integer.parseInt(br.readLine());

		String name;
		String position;
		float salary;

		Employee[] employees = new Employee[n];

		for (int i = 0; i < n; i++) {

			System.out.print("\nEnter name: ");
			name = br.readLine();

			System.out.print("\nEnter position: ");
			position = br.readLine();

			while (true) {

				System.out.print("\nEnter salary: ");
				salary = Float.parseFloat(br.readLine());

				if (salary <= 0) {
					System.out.print("Salary should be greater than 0");
				} else
					break;
			}

			employees[i] = new Employee(name, position, salary);

		}

		for (int i = 0; i < n; i++) {
			System.out.println(employees[i]);
		}

	}

}
