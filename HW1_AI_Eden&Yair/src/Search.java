import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Search {
	
	public static Maze current= null;
	
	public static void main(String[] args) {
			
		initMaze();
		
	}
	
	public static void initMaze(){
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("MazeFiles/map1.txt"));
			
			String line;
			Integer row, colmun;
			Integer startI=0, startJ=0;
			line=(in.readLine());
			
			colmun = Integer.parseInt(line.split(" ")[0]);
			row = Integer.parseInt(line.split(" ")[1]);
			
			
			char [][] maze= new char[row][colmun];
			
			for (int i=0; i<row; i++){
				line = in.readLine();
				for (int j=0; j<colmun; j++){
					if (line.charAt(j)=='s'){
						startI=i;
						startJ=j;
					}
					maze[i][j]=line.charAt(j);
				}
			}
			
			in.close();
			
			current= new Maze(maze,row,colmun,startI,startJ);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	


}
