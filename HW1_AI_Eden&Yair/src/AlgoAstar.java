import java.util.ArrayList;
import java.util.Queue;


public class AlgoAstar extends AlgoBase {
	
	@Override
	public void insertMazeCellsToQueue(ArrayList<Direction> possibleDirection,
			Maze m, Queue<MazeCell> mazeCells) {
		MazeCell temp;
for (Direction direction : possibleDirection) {
			
			nodesVisited++;
			if(direction.equals(Direction.Up))
			{
				temp = m.theMaze[m.curI -1][m.curJ];
				UpdateMazeCell(temp, m);
				mazeCells.add(temp);
			}
			if(direction.equals(Direction.Right))
			{
				temp = m.theMaze[m.curI][m.curJ+1];
				UpdateMazeCell(temp, m);
				mazeCells.add(temp);
			}
			if(direction.equals(Direction.Down))
			{
				temp = m.theMaze[m.curI + 1][m.curJ];
				UpdateMazeCell(temp, m);
				mazeCells.add(temp);
			}
			if(direction.equals(Direction.Left))
			{
				temp = m.theMaze[m.curI ][m.curJ-1];
				UpdateMazeCell(temp, m);
				mazeCells.add(temp);
			}
		}
		
	}

	private void UpdateMazeCell(MazeCell temp,Maze m) {
		temp.isVisited = true;
		temp.diraction = m.getCurrentLocation();
		temp.uniformCost = m.getCurrentLocation().uniformCost + temp.cost;
	}

}
