import java.util.HashSet;
import java.util.Set;


public class HelperMaze {
	
	public static Set<Direction> successor(Maze m){
		Set<Direction> possibleDirection= new HashSet<Direction>();
		
		return possibleDirection;
	}
	
	public static boolean isGoalState(Maze m ){
		if (m.maze[m.curI][m.curJ]=='g'){
			return true;
		}
		return false;
	}
	
}
