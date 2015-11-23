package Bina;
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
			double first =(Maze.xGoal - mc1.iCell) + (Maze.yGoal - mc1.jCell)+ mc1.uniformCost ;
			double second= (Maze.xGoal - mc2.iCell)+ (Maze.yGoal - mc2.jCell) + mc2.uniformCost;
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
			double firstp =pitaguras(mc1)+mc1.uniformCost;
			double secondp= pitaguras(mc2)+mc2.uniformCost;
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
		double x =Maze.xGoal - m.iCell , y =Maze.yGoal - m.jCell;
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

}
