package Bina;
import java.util.ArrayList;
import java.util.Queue;


public class AlgoAstar extends AlgoBase {
	
	@Override
	public void insertMazeCellsToQueue(ArrayList<Direction> possibleDirection,
			Maze m, Queue<MazeCell> mazeCells) {
		MazeCell temp;
for (Direction direction : possibleDirection) {
			
	
			if(direction.equals(Direction.Up))
			{
				temp = m.theMaze[m.curI -1][m.curJ];
				UpdateMazeCell(temp, m,mazeCells);
				//mazeCells.add(temp);
			}
			if(direction.equals(Direction.Right))
			{
				temp = m.theMaze[m.curI][m.curJ+1];
				UpdateMazeCell(temp, m,mazeCells);
				//mazeCells.add(temp);
			}
			if(direction.equals(Direction.Down))
			{
				temp = m.theMaze[m.curI + 1][m.curJ];
				UpdateMazeCell(temp, m,mazeCells);
				//mazeCells.add(temp);
			}
			if(direction.equals(Direction.Left))
			{
				temp = m.theMaze[m.curI ][m.curJ-1];
				UpdateMazeCell(temp, m,mazeCells);
				//mazeCells.add(temp);
			}
		}
		
	}

	private void UpdateMazeCell(MazeCell temp,Maze m,Queue<MazeCell> mazeCells) {
		insertOrUpadteOrIgnore(m,mazeCells,temp);
	}
	
	private  void insertOrUpadteOrIgnore(Maze m,
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


