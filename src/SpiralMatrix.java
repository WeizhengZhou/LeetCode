import java.util.*;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	if(matrix == null || matrix[0] == null) 
    		return new ArrayList<Integer>();
    	List<Integer> list = new ArrayList<>();
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int i = 0;//start row index
    	int j = 0;//start column index    	   	
    	while(i < m/2 && j < n/2){
    		for(int k=j;k<n-j-1;k++)//left top to right top
    			list.add(matrix[i][k]);
    		for(int k=i;k<m-i-1;k++)//right top to right bottom
    			list.add(matrix[k][n-j-1]);
    		for(int k=n-j-1;k>j;k--)//right bottom to left bottom
    			list.add(matrix[m-i-1][k]);
    		for(int k=m-i-1;k>i;k--)//left bottom to left top
    			list.add(matrix[k][j]);
    		i++;
    		j++;
    	}		
    	if(m < n && m%2 == 1){//e.g. m = 3, n = 4, one row left
    		for(int k=j;k<n-j;k++)
    			list.add(matrix[i][k]);
    	}
    	else if(n < m && n%2 == 1){//e.g. m = 4, n =3, one column left
    		for(int k=i;k<m-i;k++)
    			list.add(matrix[k][j]);
    	}
    	else if(m == n && m%2 == 1){//e.g. m = 3, n =3, one element left
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
