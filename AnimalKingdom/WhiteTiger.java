import java.awt.Color;

public class WhiteTiger extends Tiger{
	boolean hasInfectedAnother;
	
	public Color getColor() {
		return Color.WHITE;
	}


	public WhiteTiger() {
		super();
		hasInfectedAnother = false;
	}


	public String toString() {
		if (hasInfectedAnother) { return "TGR"; }
		return "tgr";

		
	}
	
	
	//need to change
	public Action getMove(CritterInfo info) {
		count++;
		if(info.getFront() == Neighbor.OTHER) { 
			hasInfectedAnother = true;
			return Action.INFECT; 
		}
		else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {return Action.LEFT; }
		else if(info.getFront() == Neighbor.SAME) {return Action.RIGHT; }
		return Action.HOP;
	}
	
}
