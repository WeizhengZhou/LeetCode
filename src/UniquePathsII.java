
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] grid) {
		if(grid == null || grid[0] == null) return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] L = new int[m][n];
	
    	L[0][0] = (grid[0][0] == 0)?1:0;
    	for(int j=1;j<n;j++)
    		L[0][j] = (L[0][j-1] == 1 && grid[0][j] == 0) ? 1:0;
    	
    		
    	for(int i=1;i<m;i++)
    		L[i][0] = (L[i-1][0] == 1 && grid[i][0] == 0) ? 1:0;
    	
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			if(grid[i][j] == 1)
    				L[i][j] = 0;
    			else
    			L[i][j] = L[i-1][j] + L[i][j-1];
    		}
    	}
    	
    	return L[m-1][n-1];

	}

}
