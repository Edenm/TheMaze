package Bina;
import java.util.ArrayList;
import java.util.Queue;


public class AlgoBFS extends AlgoBase {
	
	@Override
	public void insertMazeCellsToQueue(ArrayList<Direction> possibleDirection,
			Maze m, Queue<MazeCell> mazeCells) {
		MazeCell temp;
for (Direction direction : possibleDirection) {
			
		
			if(direction.equals(Direction.Up))
			{
				temp = m.theMaze[m.curI -1][m.curJ];
				UpdateMazeCell(temp, m,mazeCells);
			
			}
			if(direction.equals(Direction.Right))
			{
				temp = m.theMaze[m.curI][m.curJ+1];
				UpdateMazeCell(temp, m,mazeCells);
				
			}
			if(direction.equals(Direction.Down))
			{
				temp = m.theMaze[m.curI + 1][m.curJ];
				UpdateMazeCell(temp, m,mazeCells);
			}
			if(direction.equals(Direction.Left))
			{
				temp = m.theMaze[m.curI ][m.curJ-1];
				UpdateMazeCell(temp, m, mazeCells);
			}
		}
		
	}

	private void UpdateMazeCell(MazeCell temp,Maze m,Queue<MazeCell> mazeCells) {
		if(!mazeCells.contains(temp))
		{
		temp.diraction = m.getCurrentLocation();
		temp.uniformCost = m.getCurrentLocation().uniformCost + temp.cost;
		mazeCells.add(temp);
		}

	}
}