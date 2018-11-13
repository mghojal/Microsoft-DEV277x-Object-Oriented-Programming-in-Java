import java.awt.*;

public class Bear extends Critter{
	boolean polar;
	int count;
	
	public Bear(boolean polar) {
		super();
		this.polar = polar;
		count = 0;
	}

	
	public Color getColor() {
		if (polar==false) {return Color.BLACK;}
		return Color.WHITE;
	}


	public String toString() {
		if (count%2==0) {return "/";}
		return "\\";
	}
	
	
	//need to change
	public Action getMove(CritterInfo info) {
		count++;
		if (/*info.frontThreat() == true || info.getFront() == Neighbor.SAME || */ info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}	
		else if(info.getFront() == Neighbor.EMPTY) { return Action.HOP;}
			
		return Action.LEFT;
	}
}
