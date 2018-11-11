
abstract public class BusinessEmployee extends Employee {

	public double buddget;
	
	public BusinessEmployee(String name) {
		super(name,50000.0);
		
	}
	
	public double getBonusBudget() {
		return budget;
	}
	
	public String employeeStatus() {
		return (this.ID + " " + this.name + " with a budget of " + budget);
	}
	
	abstract public Employee getManager();

}
