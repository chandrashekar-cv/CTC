package grpahsNtrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze_FindPath {
			
	public static void main(String[] args) {
		TheMaze_FindPath sol = new TheMaze_FindPath();
		System.out.println(sol.hasPath(new int[][] {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[]{3,2}));

	}
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int m=maze.length;
		int n=maze[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		for(int i=0;i<visited.length;i++)
			Arrays.fill(visited[i], false);
		
		Queue<Cell> bfs = new LinkedList<Cell>();
		
		visited[start[0]][start[1]] = true;
		bfs.offer(new Cell(start[0],start[1]));
		
		int[][] directions= new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
		
		while(!bfs.isEmpty()) {
			Cell curr = bfs.poll();
			visited[curr.i][curr.j] = true;
			int i=curr.i;
			int j=curr.j;
			
			if(i==destination[0] && j==destination[1])
				return true;
			
			//find the next stopping point of the ball in 4 possible directions.
			for(int[] dir: directions) {
				int x = curr.i;
				int y = curr.j;
				//Ball has to keep rolling in 1 direction until it hits a wall.
				while(x>=0 && x<m && y>=0 && y<n && maze[x][y]==0) {
					x+=dir[0];
					y+=dir[1];
				}
				
				//When it stops rolling. x,y are pointing to a cell which is a wall. Inside / outside the maze matrix.
				//So step back one position to a valid stopping empty cell.
				x-=dir[0];
				y-=dir[1];
				//If that empty cell is not visited already, add to queue to start exploring.
				if(!visited[x][y])
					bfs.offer(new Cell(x,y));

			}
						
		}

		return false;
    }
	
}
class Cell{
	int i,j;
	public Cell(int x,int y) {
		i=x;
		j=y;
	}
}
