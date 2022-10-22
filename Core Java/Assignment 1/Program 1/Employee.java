public class Employee {

	String name;
	String position;
	float salary;
	
	static int objectCount=0;
	
	Employee(String name, String position, float salary){
		this.name = name;
		this.position = position;
		this.salary=salary;
		objectCount++;
		Employee.printObjectCount();
	}
	
	Employee(){
		this(null,null, 0f);  // you can call another constructor using "this" key word
	}
	
	public String toString() {
		return "Name= " + this.name + "\nPosition= " + this.position + "\nSalary=" + this.salary + "\n";
	}
	
	
	static void printObjectCount() {
		System.out.println("[Object created] Objet Count = " + Employee.objectCount);
	}
	
}

