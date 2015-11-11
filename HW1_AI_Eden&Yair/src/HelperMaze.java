import java.util.HashSet;
import java.util.Set;


public class HelperMaze {
	
	public static Set<Direction> successor(Maze m){
		Set<Direction> possibleDirection= new HashSet<Direction>();
		
		for (Direction direction : Direction.values()) {
			if(canGoTO(m,direction))
				possibleDirection.add(direction);
		}
		return possibleDirection;
	}
	
	public static boolean isGoalState(Maze m ){
		if (m.theMaze[m.curI][m.curJ].sign=='g'){
			return true;
		}
		return false;
	}
	
	private static boolean canGoTO(Maze m, Direction dir)
	{ 
		switch (dir) {
		case Right:
			if(m.curJ + 1 >= m.col || m.theMaze[m.curI][m.curJ+1].sign == '#' ||m.theMaze[m.curI ][m.curJ+1].isVisited)
				return false;
			return true;
			
		case Left:
			if(m.curJ - 1 < 0 || m.theMaze[m.curI ][m.curJ-1].sign == '#' || m.theMaze[m.curI][m.curJ-1].isVisited)
				return false;
			return true;
			
		case Up:
			if(m.curI - 1 < 0  || m.theMaze[m.curI - 1 ][m.curJ].sign == '#' || m.theMaze[m.curI - 1 ][m.curJ].isVisited)
				return false;
			return true;
			
		case Down:
			if(m.curI + 1 >= m.row || m.theMaze[m.curI + 1 ][m.curJ].sign == '#' || m.theMaze[m.curI + 1 ][m.curJ].isVisited)
				return false;
			return true;
			

		default:
			break;
		}
		return true;
		
	}
	
}
