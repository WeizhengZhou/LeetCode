
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix[0] == null) return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] column = new boolean[n];
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(row[i] == true || column[j] == true){
					matrix[i][j] = 0;				
				}
	}
}
