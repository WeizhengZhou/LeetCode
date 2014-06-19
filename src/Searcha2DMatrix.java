
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix[0] == null) return false;
		return helper(matrix,target,0,matrix.length - 1);

	}
	public boolean helper(int[][] matrix, int target, int l, int r){
		if(l > r) return false;
		if(l == r){
			binarySearch(matrix,target,l,0,matrix[0].length-1);
		}
		
		int row = (l+r)/2;
		int column = matrix[0].length;
	
		if(target == matrix[row][column/2])
			return true;
		else if(target < matrix[row][0])
			return helper(matrix,target,l,row-1);
		else if(target > matrix[row][column-1])
			return helper(matrix,target,row+1,r);
		else
			return binarySearch(matrix,target,row,0,column-1);
		
	}
	public boolean binarySearch(int[][] matrix, int target, int row,  int l, int r){
		if(l > r) return false;
		int m = (l+r)/2;
		if(target == matrix[row][m])
			return true;
		else if(target < matrix[row][m])
			return binarySearch(matrix,target,row,l,m-1);
		else 
			return binarySearch(matrix,target,row,m+1,r);	
	}
	public static void main(String[] args){
		int[][] matrix = new int[][]{{1},{3}};
		int target = 3;
		System.out.println(new Searcha2DMatrix().searchMatrix(matrix, target));
		
	}

}
