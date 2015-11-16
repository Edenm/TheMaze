import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search {

	public static Maze current = null;

	public static void main(String[] args) {

		initMaze();
		// HelperAStarAlgo.aStarMaze(current);
		// HelperBFSAlgo.nodesVisited =0;
		// HelperBFSAlgo.BFSMaze(current);
		// HelperUniformAlgo.uniformMaze(current);

//		AlgoBFS a = new AlgoBFS();
//		a.setComparator(new BFSFirstH());
//		a.Run(current);

		
		AlgoUniform a = new AlgoUniform();
		a.setComparator(new C_uniform());
		a.Run(current);
		
		// AlgoAstar ab = new AlgoAstar();
		// ab.setComparator(new AStarFirstH());
		// ab.Run(current);
		//

	}

	// ssaa
	public static void initMaze() {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("MazeFiles/map3.txt"));

			String line;
			Integer row, colmun;
			Integer startI = 0, startJ = 0;
			line = (in.readLine());

			colmun = Integer.parseInt(line.split(" ")[0]);
			row = Integer.parseInt(line.split(" ")[1]);

			MazeCell[][] mazeCells = new MazeCell[row][colmun];

			for (int i = 0; i < row; i++) {
				line = in.readLine();
				for (int j = 0; j < colmun; j++) {
					if (line.charAt(j) == 's') {
						startI = i;
						startJ = j;
					}
					if (line.charAt(j) == 'g') {
						current.xGoal = i;
						current.yGoal = j;
					}

					mazeCells[i][j] = new MazeCell(line.charAt(j), i, j);

				}
			}

			in.close();

			current = new Maze(mazeCells, row, colmun, startI, startJ,
					new AStarFirstH());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
