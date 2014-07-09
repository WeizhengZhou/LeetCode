import java.util.*;
public class MaximalRectangle {
	public int maximalRectangle(char[][] A) {
		if(A == null || A[0] == null) return 0;
		int m = A.length;
		int n = A[0].length;
		
		int[][] H = new int[m][n];
		H[0][0] = (A[0][0] == '0')?0:1;
		for(int j=1;j<n;j++)
			H[0][j] = (A[0][j] == '0')?0:1;			
		for(int i=1;i<m;i++){
			for(int j=0;j<n;j++){
				H[i][j] = (A[i][j] == '0')?0:(H[i-1][j]+1);
			}
		}
		int maxArea = 0;
		for(int i=0;i<m;i++)
			maxArea = Math.max(maxArea, histRectArea(H[i]));		
		return maxArea;
	}
	public int histRectArea(int[] h){
		int maxArea = 0;
		Stack<Integer> indexStack = new Stack<>();//stack stores an increasing sub array of h
	    int i = 0;
		while(i<h.length){			
			//stack is empty or h[i] > top
			if(indexStack.isEmpty() || h[i] > h[indexStack.peek()])
				indexStack.push(i++);
			else{
				//h[i] < top and top > stack(top-1),
				//if use top as the minimum height of a rectangle, 
				//it can extend left to stack(top-1) and right to h[i]
				//if stack is not empty, left boundary has index stack.peek(), and right boundary has index i,
				//since left boundary and right boundary are not included in the rectangle, width = i - indexStack.peek() - 1
				//if stack is empty, h[0...i] is a decreasing array, otherwise the stack cannot be empty
				//therefore, the top element has index i-1, and stack has i elements in total
				//so, the rectangle has a width i
				int height = h[indexStack.pop()];
				int width = indexStack.isEmpty()?i:(i - indexStack.peek() - 1);
				int area = height * width;
				maxArea = (area > maxArea) ? area:maxArea;
			}
		}
		while(!indexStack.isEmpty()){
			int height = h[indexStack.pop()];
			int width = indexStack.isEmpty()?i:(i - indexStack.peek() - 1);
			int area = height * width;
			maxArea = (area > maxArea) ? area:maxArea;
		}
			
		return maxArea;
		
	}
	public static void main(String[] args){
    	int[] A = new int[]{2,1,5,6,2,3};
//    	int[] A = new int[]{4,2};
    	char[][] C = new char[][]{{'0','1','1','1'},
    			                  {'0','1','1','1'},
    			                  {'1','1','0','1'},
    			                  {'1','1','1','1'},};
    	MaximalRectangle s = new MaximalRectangle();
    	System.out.println(s.maximalRectangle(C));
    	
    	
    }
}
