package Bina;
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
			int first = Math.abs( Maze.xGoal-mc1.iCell)+Math.abs(Maze.yGoal - mc1.jCell);
			int second = Math.abs(Maze.xGoal-mc2.iCell)+Math.abs(Maze.yGoal - mc2.jCell);
			if (first > second)
				return 1;
			if(first == second)
			{
				
				if(mc1.iCell > mc2.iCell)
					return 1;
				if(mc1.iCell < mc2.iCell)
					return -1;
				
				if(mc1.jCell > mc2.jCell)
					return 1;
				if(mc1.jCell < mc2.jCell)
					return -1;
				
				if(mc1.iCell < mc2.iCell)
					return 1;
				if(mc1.iCell > mc2.iCell)
					return -1;
				
				if(mc1.jCell < mc2.jCell)
					return 1;
				if(mc1.jCell > mc2.jCell)
					return -1;
			}
			return -1;
			
		case 2:
			double firstp =pitaguras(mc1);
			double secondp= pitaguras(mc2);
			   if (firstp > secondp)
			   		return 1;
				if(firstp == secondp)
				{
					if(mc1.iCell > mc2.iCell)
						return 1;
					if(mc1.iCell < mc2.iCell)
						return -1;
					
					if(mc1.jCell > mc2.jCell)
						return 1;
					if(mc1.jCell < mc2.jCell)
						return -1;
					
					if(mc1.iCell < mc2.iCell)
						return 1;
					if(mc1.iCell > mc2.iCell)
						return -1;
					
					if(mc1.jCell < mc2.jCell)
						return 1;
					if(mc1.jCell > mc2.jCell)
						return -1;
				}
			   return -1;
			   
			   
		default: return 1;
		}
		
		
		
	}

	private Double pitaguras(MazeCell m){
		int x =Maze.xGoal - m.iCell , y =Maze.yGoal - m.jCell;
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}
