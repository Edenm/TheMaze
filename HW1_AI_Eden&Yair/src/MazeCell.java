
public class MazeCell {
	
	public char sign;
	
	public Boolean isVisited;
	
	public int iCell,jCell;
	
	
	
	public MazeCell(char charAt, int i, int j) {
		sign = charAt;
		iCell = i;
		jCell =j;
		isVisited =false;
	}
	
	@Override
	public String toString() {
		return ""+sign;
	}
	
	

}
