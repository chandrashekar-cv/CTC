package algos;

public class UniquePath_I_and_II {

	public static void main(String[] args) {
		UniquePath_I_and_II sol = new UniquePath_I_and_II();
		System.out.println(sol.uniquePaths(7, 3));
		
		System.out.println(sol.uniquePathsWithObstacles(new int[][] {{0,0},{0,1}}));

	}
	
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 int m=obstacleGrid.length;
		 int n = obstacleGrid[0].length;
		 
		 int[][] count = new int[m][n];
		 
		 count[0][0] = 1-obstacleGrid[0][0];
		 
		 for(int i=1;i<m;i++) 
			 count[i][0] = obstacleGrid[i][0]==1 ?0:count[i-1][0];
		 
		 for(int j=1;j<n;j++)
			 count[0][j] = obstacleGrid[0][j]==1 ?0:count[0][j-1];
				 
		 for(int i=1;i<m;i++) {
			 for(int j=1;j<n;j++) {
				 
				int top = obstacleGrid[i][j]==1?0:count[i-1][j];
				int left = obstacleGrid[i][j]==1?0:count[i][j-1];
				count[i][j] = top+left;
				

			 }
		 }
		 
		 return count[m-1][n-1];
	 }
	 
	 public int uniquePaths(int m, int n) {
		 
		 int[][] count = new int[m][n];
		 
		 count[0][0] = 1;
		 for(int i=0;i<m;i++) {
			 for(int j=0;j<n;j++) {
				 if(i==0 && j==0)
					 continue;
				 
				 int top = i>0?count[i-1][j]:0;
				 int left = j>0?count[i][j-1]:0;
				 count[i][j] = top+left;
				 
			 }
		 }
		 
		 return count[m-1][n-1];
	        
	 }

}
