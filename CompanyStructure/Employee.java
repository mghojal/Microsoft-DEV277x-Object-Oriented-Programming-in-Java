abstract public class Employee {
	String name;
	double baseSalary;
	int ID;
	private static int countEmployee;
	double bonus;
	double budget;
	
	public Employee(String name, double baseSalary) {
		this.name = name;
		this.baseSalary = baseSalary;
		countEmployee++;
		ID = countEmployee;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getEmployeeID() {
		return ID;
	}
	
	abstract public Employee getManager();
	
	public boolean equals(Employee other) {
		return this.ID == other.ID;
	}
	
	public String toString() {
		return (this.ID + " " + this.name);
	}
	
	abstract public String employeeStatus();
}
