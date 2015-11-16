import java.util.Comparator;

public class C_AStar implements Comparator<MazeCell> {

	private int uristic;
	
	public C_AStar(int uristic) {
		super();
		this.uristic = uristic;
	}

	@Override
	public int compare(MazeCell mc1, MazeCell mc2) {

		switch (uristic) {
		case 1:
				if ((Maze.xGoal - mc1.iCell) + (Maze.yGoal - mc1.jCell)
					+ mc1.uniformCost > (Maze.xGoal - mc2.iCell)
					+ (Maze.yGoal - mc2.jCell) + mc2.uniformCost)
				return 1;
			return -1;
			
		case 2:
			   if ((pitaguras(mc1)+mc1.uniformCost) > (pitaguras(mc2)+mc2.uniformCost))
			   		return 1;
			   return -1;
			   
		default: return 1;
		}
	}
	
	
	private Double pitaguras(MazeCell m){
		int x =Maze.xGoal - m.iCell , y =Maze.yGoal - m.jCell;
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

}
