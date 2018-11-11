
abstract public class TechnicalEmployee extends Employee {
	int checkIn;
	
	public TechnicalEmployee(String name) {
		super(name,75000.0);
	}
	
	public String employeeStatus() {
		return (this.ID + " " + this.name + " has " + checkIn + "successful ckeck ins" + "\n");
	}
	
	public int checkIn() {
		return checkIn++;
	}
	
	abstract public Employee getManager();

}
