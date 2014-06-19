
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if(m == 0 || n == 0) return 0;
		int[][] L = new int[m][n];
	
    	L[0][0] = 1;
    	for(int j=1;j<n;j++)
    		L[0][j] = 1;
    	for(int i=1;i<m;i++)
    		L[i][0] = 1;
    	
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			L[i][j] = L[i-1][j] + L[i][j-1];
    		}
    	}
    	return L[m-1][n-1];
	}

}
