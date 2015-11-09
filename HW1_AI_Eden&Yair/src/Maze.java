
public class Maze {

	public char [][] maze;
	public int row, col;
	public int curI, curJ;
	
	public Maze() {
		super();
	}
	
	public Maze( char [][] maze ,int row,int col, int curI,int curJ ) {
		super();
		this.maze = maze;
		this.row=row;
		this.col=col;
		this.curI=curI;
		this.curJ=curJ;
	}
	
	@Override
	public String toString() {
		String mazeString="";
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				mazeString+=""+maze[i][j];
			}
			mazeString+="\n";
		}
		return mazeString;
	}
	
	
	
}
