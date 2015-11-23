package Bina;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public abstract class AlgoBase {
	
 int  nodesVisited =0;
 
 public Comparator<MazeCell> comparator;
	

	public void setComparator(Comparator<MazeCell> comparator) {
	this.comparator = comparator;
}


	public  void  Run(Maze m)
	{
		Queue<MazeCell> mazeCells = new PriorityQueue<MazeCell>(m.col * m.row, comparator);
		
		ArrayList<Direction> possibleDirection;
		
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
				nodesVisited++;
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
		
		
		public abstract  void insertMazeCellsToQueue(ArrayList<Direction> possibleDirection, Maze m,Queue<MazeCell> mazeCells);


		

}
