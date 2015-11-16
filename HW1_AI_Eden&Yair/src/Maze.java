import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;

public class Maze {

	public MazeCell[][] theMaze;
	public int row, col;
	public int curI, curJ;
    public static int xGoal;
	
	public static int yGoal;
	
	public Comparator<MazeCell> comparator;

	public Maze() {
		super();
	}

	public Maze(MazeCell[][] maze, int row, int col, int curI, int curJ, Comparator<MazeCell> comparator ) {
		super();
		this.theMaze = maze;
		this.row = row;
		this.col = col;
		this.curI = curI;
		this.curJ = curJ;
		this.comparator = comparator;
	}
	
	public MazeCell getCurrentLocation()
	{
		return theMaze[curI][curJ];
	}
	
	public void setCurrentLocation(int i, int j)
	{
		curI =i;
		
		curJ =j;
	}

	public  void move(Direction direction) {
	
			if(direction.equals(Direction.Up))
			{
				curI++;
			}
			if(direction.equals(Direction.Right))
			{
				curJ++;
			}
			if(direction.equals(Direction.Down))
			{
				curI--;
			}
			if(direction.equals(Direction.Left))
			{
				curJ--;
			}
	}
		
	@Override
	public String toString() {
		String mazeString = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				mazeString += "" + theMaze[i][j];
			}
			mazeString += "\n";
		}
		return mazeString;
	}

}
