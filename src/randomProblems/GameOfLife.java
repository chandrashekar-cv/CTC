package randomProblems;

/*According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

*/

public class GameOfLife {

	public static void main(String[] args) {
		GameOfLife sol = new GameOfLife();
		sol.gameOfLife(new int[][] {{1,1},{1,0}});
		System.out.println("done");
	}
	
	public void gameOfLife(int[][] board) {
		if(board==null)
			return;
		
		int m=board.length;
		int n = board[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				
				int liveNighbors = getLiveneighbors(board, m, n, i, j);
				
				if((board[i][j]&1)==1 && liveNighbors>=2 && liveNighbors<=3)
					board[i][j]= 3;
				
				if((board[i][j]&1)==0 && liveNighbors==3)
					board[i][j] = 2;
				
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++)
				board[i][j] = board[i][j]>>1;
		}
		
    }
	
	public int getLiveneighbors(int[][] board,int m, int n, int i, int j) {
		int liveNeighbors = 0;
		
		for(int x = Math.max(i-1, 0); x<=Math.min(i+1, m-1);x++) {
			for(int y= Math.max(j-1, 0);y<=Math.min(j+1,n-1);y++) {
				liveNeighbors += (board[x][y]&1);
			}
		}
		
		liveNeighbors = liveNeighbors - (board[i][j]&1);
		
		
		return liveNeighbors;
	}
	

}
