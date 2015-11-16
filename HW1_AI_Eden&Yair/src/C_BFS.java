import java.util.Comparator;


public class C_BFS implements Comparator<MazeCell> {

	private int uristic;
	
	public C_BFS(int uristic) {
		super();
		this.uristic = uristic;
	}
	
	@Override
	public int compare(MazeCell mc1, MazeCell mc2) {
	
		switch (uristic) {
		case 1:
			if ((Math.abs( Maze.xGoal-mc1.iCell))+(Math.abs(Maze.yGoal - mc1.jCell)) > (Math.abs(Maze.xGoal-mc2.iCell))+(Math.abs(Maze.yGoal - mc2.jCell)))
				return 1;
			return -1;
			
		case 2:
			   return pitaguras(mc1).compareTo(pitaguras(mc2));
			   
		default: return 1;
		}
		
		
		
	}

	private Double pitaguras(MazeCell m){
		int x =Maze.xGoal - m.iCell , y =Maze.yGoal - m.jCell;
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}
