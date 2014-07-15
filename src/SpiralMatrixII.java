
public class SpiralMatrixII {
	 public int[][] generateMatrix(int n) {
		 
		 int[][] matrix = new int[n][n];
		 int count = 1;
		 int i = 0;	
		 while(i < n/2){
			for(int k=i;k<n-i-1;k++)//left top to right top
				matrix[i][k] = count++;
			for(int k=i;k<n-i-1;k++)//right top to right bottom
				matrix[k][n-i-1] = count++;
			for(int k=n-i-1;k>i;k--)//right bottom to left bottom
				matrix[n-i-1][k] = count++;
			for(int k=n-i-1;k>i;k--)//left bottom to left top
				matrix[k][i] = count++;
			i++;			
		 }

		 if(n % 2 == 1)
			 matrix[n/2][n/2] = count++;
		 return matrix;        
	 }
    	
   
    public static void main(String[] ags){  	
    	SpiralMatrixII solution = new SpiralMatrixII();
    	int[][] matrix = solution.generateMatrix(4);
    	solution.print(matrix);
    	   	
    }
    private void print(int[][] m){
    	for(int[] row:m){
    		for(int e:row){
    			System.out.print(e+",");
    		}
    		System.out.println();
    	}
    }

}
