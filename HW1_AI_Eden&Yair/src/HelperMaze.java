import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class HelperMaze {
	
	public static ArrayList<Direction> successor(Maze m){
		ArrayList<Direction> possibleDirection= new ArrayList<Direction>();
		
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
	
	
	
	public static ArrayList<Direction> wayToSoulation(MazeCell mc)
	{
		ArrayList<Direction> route = new ArrayList<Direction>();
		
		while(mc.diraction != null)
		{
			route.add(mc.whereIComeFromDiraction());
			mc = mc.diraction;
		}
		
		return route;
	}
	
	public static void printRouteToSulotion(ArrayList<Direction> route)
	{
		for(int i= route.size() -1; i >= 0; i--)
		{
			System.out.print(route.get(i)+" -> ");
		}
		System.out.println();
	}
	
	public static void printMazeSulotion(Maze m, MazeCell mc)
	{
		mc= mc.diraction;
		while(mc.diraction != null)
		{
			mc.sign = '@';
			mc = mc.diraction;
		}
		
		System.out.println(m);
	}
	
	
	
	
}
