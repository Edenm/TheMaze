import java.util.Comparator;

public class AStarFirstH implements Comparator<MazeCell> {

	@Override
	public int compare(MazeCell mc1, MazeCell mc2) {

		if ((Maze.xGoal - mc1.iCell) + (Maze.yGoal - mc1.jCell)
				+ mc1.uniformCost > (Maze.xGoal - mc2.iCell)
				+ (Maze.yGoal - mc2.jCell) + mc2.uniformCost)
			return 1;
		return -1;

	}

}
