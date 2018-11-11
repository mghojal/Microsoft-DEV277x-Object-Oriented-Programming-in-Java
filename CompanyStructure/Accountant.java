
public class Accountant extends BusinessEmployee{
	
	TechnicalLead lead;
	BusinessLead manager;
	
	public Accountant(String name) {
		super(name);
	}
	
	public TechnicalLead getTeamSupported() {
		return lead;
	}
	
	public void supportTeam(TechnicalLead leadA) {
		lead = leadA;
		lead.support = this;
		double total = 0;
		for (int i = 0; i < lead.directReport.size(); i++) {
			total+=lead.directReport.get(i).getBaseSalary();
		}
		budget = total*1.1;
	}
	
	public boolean approveBonus(double bonus) {
		if(bonus>budget || lead==null) { return false; }
		return true;
	}
	
	public String employeeStatus() {
		return (super.employeeStatus() + " is supporting " + this.lead + "\n");
	}
	
	public Employee getManager() {
		return this.manager;
	}
	
}
