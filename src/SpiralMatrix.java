import java.util.*;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	if(matrix == null) return new ArrayList<Integer>();
    	
    	List<Integer> list = new ArrayList<>();
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	while(i < m/2 && j < n/2){
    		k = j;
    		while(k < n - j - 1)
    			list.add(matrix[i][k++]);
    		k = i;
    		while(k< m -i -1)
    		list.add(matrix[k++][n-j-1]);
    		k = n - j - 1;
    		while(k > j)
    			list.add(matrix[m-i-1][k--]);
    		k = m - i -1;
    		while(k > i)
    			list.add(matrix[k--][j]);
    		i++;
    		j++;
    	}
		
    	if(m < n && m%2 == 1){
    		k = j;
    		while(k <= n - i - 1)
    			list.add(matrix[i][k++]);	
    	}
    	else if(n < m && n%2 == 1){
    		k = i;
    		while(k <= m -i -1)
        		list.add(matrix[k++][n-j-1]);
    		
    	}
    	else if(m == n && m%2 == 1){

    		list.add(matrix[i][j]);
    	}
    	return list;        
    }
    public static void main(String[] ags){
//    	int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	int[][] matrix = new int[][]{{1,2},{3,4},{5,6}};
    	SpiralMatrix solution = new SpiralMatrix();
    	System.out.println(solution.spiralOrder(matrix));
    	
    	
    }

}
