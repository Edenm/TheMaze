import java.util.ArrayList;
import java.util.Queue;


public class AlgoUniform extends AlgoBase {

	@Override
	public void insertMazeCellsToQueue(ArrayList<Direction> possibleDirection,
			Maze m, Queue<MazeCell> mazeCells) {
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

