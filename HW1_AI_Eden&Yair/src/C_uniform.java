

import java.util.Comparator;

public class C_uniform implements Comparator<MazeCell> {
	
	@Override
	public int compare(MazeCell mc1, MazeCell mc2) {

		if (mc1.uniformCost > mc2.uniformCost)
		     return 1;
		    return -1;

	}

}
