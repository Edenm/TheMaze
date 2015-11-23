package Bina;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search {

	public static Maze current = null;

	public static void main(String[] args) {
		//‘java map1.txt a2’ 
		String mapName =null;
		String algo =null;
		Integer uristic= null; 
		mapName=args[0];
		algo=args[1];
		initMaze(mapName);
		
		if (algo.length()>1){
			uristic=Integer.parseInt(""+algo.charAt(1));
			algo=""+algo.charAt(0);
		}
		
		switch (algo) {
		case "u": AlgoUniform u = new AlgoUniform();
				   u.setComparator(new C_uniform());
				   System.out.println("Uniform algorithm: ");
				   u.Run(current);
			break;
		case "b": AlgoBFS bfs = new AlgoBFS();
				  bfs.setComparator(new C_BFS(uristic));
				  System.out.println("BFS algorithm with heuristic "+ (uristic == 1 ? "manhattan" : "pythagoras"));
				  bfs.Run(current);
			break;
		case "a":  AlgoAstar ab = new AlgoAstar();
				   ab.setComparator(new C_AStar(uristic));
				   
				  System.out.println("A* algorithm with heuristic "+ (uristic == 1 ? "manhattan" : "pythagoras"));
		           ab.Run(current);
			
			break;
		default:
			break;
		}
		
	}

	public static void initMaze(String map) {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("MazeFiles/"+map));

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
						Maze.xGoal = i;
						Maze.yGoal = j;
					}

					mazeCells[i][j] = new MazeCell(line.charAt(j), i, j);

				}
			}

			in.close();

			current = new Maze(mazeCells, row, colmun, startI, startJ);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
