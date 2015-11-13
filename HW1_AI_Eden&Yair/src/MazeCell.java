import javax.swing.Icon;


public class MazeCell implements Comparable<MazeCell> {
	
	public char sign;
	
	public Boolean isVisited;
	
	public int iCell,jCell;
	
	public MazeCell diraction;
	
	public int cost;
	
	public int uniformCost =0;
	
	
	
	public MazeCell(char charAt, int i, int j) {
		sign = charAt;
		iCell = i;
		jCell =j;
		isVisited =false;
		if(sign == '.')
			cost = 1;
		if(sign == ',')
			cost = 2;
	}
	
	@Override
	public String toString() {
		return ""+sign;
	}
	
	public Direction whereIComeFromDiraction()
	{
		if(diraction.iCell > iCell)
			return Direction.Up;
		if(diraction.iCell < iCell)
			return Direction.Down;
		if(diraction.jCell > jCell)
			return Direction.Left;
		else
			return Direction.Right;
	}

	@Override
	public int compareTo(MazeCell o) {
		if (this.uniformCost > o.uniformCost)
		     return 1;
		    return -1;
	}
	
	

}
