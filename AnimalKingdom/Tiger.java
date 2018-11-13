import java.awt.Color;
import java.util.Random;

public class Tiger extends Critter{
	int count;
	int i;

	
	public Tiger() {
		super();
		count = 0;
	}


	public Color getColor() {
		Color[] colorTiger = {Color.RED , Color.GREEN , Color.BLUE};
		if (count%3==0) {i = (int) (Math.random()*3); }
		return colorTiger[i];
	} 


	public String toString() {
		return "TGR";
	}
	
	
	//need to change
	public Action getMove(CritterInfo info) {
		count++;
		if(info.getFront() == Neighbor.OTHER) { return Action.INFECT; }
		else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {return Action.LEFT; }
		else if(info.getFront() == Neighbor.SAME) {return Action.RIGHT; }
		return Action.HOP;
	}
	
}
