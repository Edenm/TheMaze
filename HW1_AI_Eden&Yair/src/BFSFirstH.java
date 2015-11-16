import java.util.Comparator;


public class BFSFirstH implements Comparator<MazeCell> {

	@Override
	public int compare(MazeCell mc1, MazeCell mc2) {
	
	
		if ((Math.abs( Maze.xGoal-mc1.iCell))+(Math.abs(Maze.yGoal - mc1.jCell)) > (Math.abs(Maze.xGoal-mc2.iCell))+(Math.abs(Maze.yGoal - mc2.jCell)))
			return 1;
		return -1;
		
	}

}
