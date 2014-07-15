import java.util.Arrays;


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
	
	public void setZeroes_ConstSpace(int[][] A){//constant sapce
		if(A == null || A[0] == null) return;
		int m = A.length;
		int n = A[0].length;
		
		boolean isFirstRowZero = false;//is first row has zero
		boolean isFirstColumnZero = false;//is first column has zero
		
		for(int j=0;j<n;j++)
			if(A[0][j] == 0)
				isFirstRowZero = true;//first row has zero
		for(int i=0;i<m;i++)
			if(A[i][0] == 0)
				isFirstColumnZero = true;//first column has zero
		for(int i=1;i<m;i++){//use first row and column as O(m+n) storage space 
			for(int j=1;j<n;j++){
				if(A[i][j] == 0){
					A[0][j] = 0;
					A[i][0] = 0;
				}
			}
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(A[0][j] == 0 || A[i][0] == 0)
					A[i][j] = 0;//set zeros according to the first row and first column
			}
		}
		if(isFirstRowZero){
			for(int j=0;j<n;j++)
				A[0][j] = 0;//set first row
		}
		if(isFirstColumnZero){
			for(int i=0;i<m;i++)				
				A[i][0] = 0;//set first column	
		}			
	}
	public static void main(String[] args){
		int[][] A = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		new SetMatrixZeroes().setZeroes(A);
		System.out.println(Arrays.deepToString(A));
	}
}
