import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee{

	ArrayList<Accountant> directReport = new ArrayList<>();
	int headCount;
	
	public BusinessLead(String name) {
		super(name);
		baseSalary*=2.0;
		headCount = 10;

	}
	
	
	public boolean hasHeadCount() {
		return directReport.size() < headCount;
	}
	
	public boolean addReport(Accountant e, TechnicalLead supportTeam) {
		if(hasHeadCount()) {
			directReport.add(e);
			e.manager = this;
			budget+=(1.1*e.getBaseSalary());
			e.supportTeam(supportTeam);
			return true;
		}	
		return false;
	}
	
	public boolean requestBonus(Employee e, double bonus) {
		if(budget>=bonus) {
			e.bonus += bonus;
			budget-=bonus;
			return true;
		}
		return false;
	}
	
	public boolean approveBonus(Employee e, double bonus) {
		for(int i=0; i<directReport.size();i++) {
			if (directReport.get(i).equals(e.getManager()) && directReport.get(i).approveBonus(bonus)) {
				return true;
			}
		}
		return false;
	}
	
	public String getTeamStatus() {
		String s = employeeStatus();
		if (directReport.size() == 0) {
			s+="and no direct reports yet\n";
		}
		else {
			s+=" and is managing:\n";
			for(int i =0;i<directReport.size();i++) {
				int j =i+1;
				s+="\t" + j + ". " + directReport.get(i).employeeStatus() ;
			}
		}

		return s;
	}
	
	public Employee getManager() {
		return null;
	}
	
	
	
	
}
