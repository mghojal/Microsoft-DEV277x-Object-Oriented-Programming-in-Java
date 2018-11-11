import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee{
	
	ArrayList<SoftwareEngineer> directReport = new ArrayList<>();
	int headCount;
	BusinessLead lead;
	Accountant support;

	
	public TechnicalLead(String name) {
		super(name);
		baseSalary*=1.3;
		headCount = 4;
	}
	
	public boolean hasHeadCount() {
		return (headCount >= directReport.size());
	}
	
	public boolean addReport(SoftwareEngineer e) {
		if(directReport.size()<headCount) {
			directReport.add(e);
			e.manager = this;
			return true;
		}	
		return false;
	}
	
	public boolean approveCheckIn(SoftwareEngineer e) {
		if (this.directReport.contains(e) && e.codeAccess == true) {
			return true;
		}
		return false;
	}
	
	
	public boolean requestBonus(Employee e, double bonus) {
		if (this.support.manager.approveBonus(e, bonus)) {
			e.bonus+=bonus;
			return true;
		}
		return false;
	}
	
	public String getTeamStatus() {
		boolean end = false;
		String s = this.ID + " " + this.name + " has " + this.checkIn + " successful check ins and ";
		if (this.directReport == null) {
			s+="no direct reports yet\n";
			end = true;
		}
		else {
			s+="is managing:\n";
		}
		if(end != true)
		{
			for(int i = 0;i<directReport.size();i++) {
				int j=i+1;
				s+=("\t" + j + ". " + directReport.get(i).ID + " " + directReport.get(i).name + " has " + directReport.get(i).checkIn + " successful check ins\n"); ;  
			}
		}
		return s;
	}
	
	
	public Employee getManager() {
		return null;
	}
	
}
