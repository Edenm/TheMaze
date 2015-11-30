package Bina;

public class AtaxxBoard {
	
	final int size=7;
	public int  [][] board;

	public AtaxxBoard() {
		
		this.board = new int[size][size];
		board[0][0]=1;
		board[6][6]=1;
		board[0][0]=2;
		board[0][0]=2;
		
	}
	
}
