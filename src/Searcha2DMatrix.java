
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix[0] == null) return false;
		return helper(matrix,target,0,matrix.length - 1);

	}
	public boolean helper(int[][] matrix, int target, int l, int r){
		if(l > r) return false;	
		int m = (l+r)/2;//middle row
		int n = matrix[0].length;//column length
		if(target < matrix[m][0])//search upper half of matrix
			return helper(matrix,target,l,m-1);
		else if(target > matrix[m][n-1])//search bottom half of matrix
			return helper(matrix,target,m+1,r);
		else
			return binarySearch(matrix[m],target,0,n-1);//search this row
		
	}
	public boolean binarySearch(int[] A, int target, int l, int r){
		if(l > r) return false;
		int m = (l+r)/2;
		if(target == A[m])
			return true;
		else if(target < A[m])
			return binarySearch(A,target,l,m-1);
		else 
			return binarySearch(A,target,m+1,r);	
	}
	public static void main(String[] args){
		int[][] matrix = new int[][]{{1},{3}};
		int target = 3;
		System.out.println(new Searcha2DMatrix().searchMatrix(matrix, target));
		
	}
}
