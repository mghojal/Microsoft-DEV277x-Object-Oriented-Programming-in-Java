
public class SoftwareEngineer extends TechnicalEmployee{
	
	boolean codeAccess;
	TechnicalLead manager;
	
	public SoftwareEngineer(String name) {
		super(name);
	}
	
	public boolean getCodeAccess() {
		return codeAccess;
	}
	
	public void setCodeAccess(boolean access) {
		codeAccess = access;
	}
	
	public int getSuccessfulCheckIns() {
		return checkIn;
	}
	
	// need to double check the 2 next methods
	public boolean checkInCode() {
		if (manager.approveCheckIn(this)) {
			checkIn++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Employee getManager() {
		return this.manager;
	}
	
	
}


