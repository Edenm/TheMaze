import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class HelperBFSAlgo {
	
	static int  nodesVisited =0; 
	
	public static void  BFSMaze(Maze m)
	{
		Queue<MazeCell> mazeCells = new LinkedList<MazeCell>();
		
		Set<Direction> possibleDirection;
		
	
		mazeCells.add(m.getCurrentLocation());
		
		while(!mazeCells.isEmpty())
		{
			 m.getCurrentLocation().isVisited = true;

			 if(HelperMaze.isGoalState(m))
			 {
			   System.out.println("win in i: "+m.curI +" j: "+m.curJ);
			   ArrayList<Direction> d = HelperMaze.wayToSoulation(m.getCurrentLocation());
			   HelperMaze.printRouteToSulotion(d);
			   System.out.println("The total cost of the path found: "+ d.size());
			   
			   System.out.println("The number of nodes visited: "+nodesVisited);
			   HelperMaze.printMazeSulotion(m, m.getCurrentLocation());
			   return;
			 }
			 
			 possibleDirection=HelperMaze.successor(m);
			 
			 System.out.println("a");
			 insertMazeCellsToQueue(possibleDirection,m,mazeCells);
			// System.out.println("<"+possibleDirection+">");
			
			
			 
			 MazeCell pre =mazeCells.poll();
			 
			// System.out.println("next step : i: "+pre.iCell+" j: "+pre.jCell );
			 
			 if(mazeCells.isEmpty())
			 {
			   System.out.println(" The number of nodes visited: "+nodesVisited);
			   System.out.println("no solution has been found");
			   return;
			 }
			 
			 MazeCell next = mazeCells.peek();
			 m.setCurrentLocation(next.iCell, next.jCell);
			 		
		}
		
		
		
	}

	private static void insertMazeCellsToQueue(
			Set<Direction> possibleDirection, Maze m,Queue<MazeCell> mazeCells) {
		
		for (Direction direction : possibleDirection) {
			nodesVisited++;
			if(direction.equals(Direction.Up))
			{
				m.theMaze[m.curI -1][m.curJ].isVisited = true;
				m.theMaze[m.curI -1][m.curJ].diraction = m.getCurrentLocation();
				mazeCells.add(m.theMaze[m.curI -1][m.curJ]);
			}
			if(direction.equals(Direction.Right))
			{
				m.theMaze[m.curI][m.curJ+1].isVisited = true;
				m.theMaze[m.curI][m.curJ+1].diraction = m.getCurrentLocation();
				mazeCells.add(m.theMaze[m.curI][m.curJ+1]);
			}
			if(direction.equals(Direction.Down))
			{
				m.theMaze[m.curI + 1][m.curJ].isVisited = true;
				m.theMaze[m.curI + 1][m.curJ].diraction = m.getCurrentLocation();
				mazeCells.add(m.theMaze[m.curI + 1][m.curJ]);
			}
			if(direction.equals(Direction.Left))
			{
				m.theMaze[m.curI ][m.curJ-1].isVisited =true;
				m.theMaze[m.curI ][m.curJ-1].diraction = m.getCurrentLocation();
				mazeCells.add(m.theMaze[m.curI ][m.curJ-1]);
			}
		}
		
	}

}
