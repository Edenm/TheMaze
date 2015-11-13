import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class HelperUniformAlgo {
	
	static int  nodesVisited =0;
	
	public static void  uniformMaze(Maze m)
	{
		Queue<MazeCell> mazeCells = new PriorityQueue<MazeCell>();
		
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
			   System.out.println("The total cost of the path found: "+ m.getCurrentLocation().uniformCost);
			   
			   System.out.println("The number of nodes visited: "+nodesVisited);
			   HelperMaze.printMazeSulotion(m, m.getCurrentLocation());
			   return;
			 }
			 
			 possibleDirection=HelperMaze.successor(m);
			 
			 
			 
			
			
			 
			 MazeCell pre =mazeCells.poll();
			 pre.isVisited = true;
			 insertMazeCellsToQueue(possibleDirection,m,mazeCells);
			// System.out.println("next step : i: "+pre.iCell+" j: "+pre.jCell );
			 
			 if(mazeCells.isEmpty())
			 {
			   System.out.println(" The number of nodes visited: "+nodesVisited);
			   System.out.println("no solution has been found");
			   return;
			 }
			 
			 MazeCell next = mazeCells.peek();
			 m.setCurrentLocation(next.iCell, next.jCell);}
			 		
		}
		
		
		private static void insertMazeCellsToQueue(
				Set<Direction> possibleDirection, Maze m,Queue<MazeCell> mazeCells) {
			
			for (Direction direction : possibleDirection) {
				nodesVisited++;
				MazeCell temp;
				if(direction.equals(Direction.Up))
				{
					temp = m.theMaze[m.curI -1][m.curJ];
					insertOrUpadteOrIgnore(m, mazeCells, temp);
										
				}
				if(direction.equals(Direction.Right))
				{
				
					temp = m.theMaze[m.curI][m.curJ+1];
					insertOrUpadteOrIgnore(m, mazeCells, temp);
				}
				if(direction.equals(Direction.Down))
				{
					
					temp = m.theMaze[m.curI + 1][m.curJ];
					insertOrUpadteOrIgnore(m, mazeCells, temp);
				}
				if(direction.equals(Direction.Left))
				{
					
					temp= m.theMaze[m.curI ][m.curJ-1];
					insertOrUpadteOrIgnore(m, mazeCells, temp);
				}
			}
		
	}


		private static void insertOrUpadteOrIgnore(Maze m,
				Queue<MazeCell> mazeCells, MazeCell temp) {
			if(mazeCells.contains(temp))
			{
				if(temp.uniformCost > m.getCurrentLocation().uniformCost+temp.cost)
				{
					// where i come from 
					temp.diraction = m.getCurrentLocation();
				// update the cost
					temp.uniformCost = temp.cost + temp.diraction.uniformCost;	
				}
				
			}
			else{
				
			// where i come from 
				temp.diraction = m.getCurrentLocation();
			// update the cost
				temp.uniformCost = temp.cost + temp.diraction.uniformCost;
				
			// add to queue
				mazeCells.add(temp);						
			}
		}

}
