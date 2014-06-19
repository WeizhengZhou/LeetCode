
public class SpiralMatrixII {
	 public int[][] generateMatrix(int n) {
		 
		 int[][] matrix = new int[n][n];
		 int count = 1;
		 int i = 0;	
		 int k = 0;
		 while(i < n/2){
			 k = i;
			 while(k < n - i - 1)
				 matrix[i][k++] = count++;			 
			 k = i;
			 while(k < n -i -1)
			     matrix[k++][n-i-1] = count++;
			 k = n - i - 1;
			 while(k > i)
				matrix[n-i-1][k--] = count++;
			 k = n - i -1;
			 while(k > i)
				 matrix[k--][i] = count++;
			 i++;			
		 }

		 if(n % 2 == 1){
			 matrix[n/2][n/2] = count++;
		 }
		 
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
