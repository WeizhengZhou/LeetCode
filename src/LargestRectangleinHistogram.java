import java.util.*;
public class LargestRectangleinHistogram {
//    public int largestRectangleArea(int[] A) {
//    	int maxArea = 0;
//    	for(int i=0;i<A.length;i++){
//    		int minHeight = A[i];
//    		for(int j=i;j<A.length;j++){
//    			minHeight = Math.min(minHeight, A[j]);
//    			maxArea = Math.max(maxArea,(j-i+1)*minHeight);
////    			System.out.println("i = " + i + ", j = " + j + ", minHeight = " + minHeight + ", maxArea = " + maxArea );
//    		}
//    	}
//    	return maxArea;
//        
//    }
	public int largestRectangleArea(int[] A){
		if(A == null ) return 0;
		Stack<Integer> stack = new Stack<>();
		int i= 0;
		int maxArea = 0;
		while(i < A.length){
			if(stack.isEmpty() || A[i] > A[stack.peek()]){
				stack.push(i++);
			}
			else{				
				int min = stack.pop();// top element as the short bar
			    //If stack is empty, the ith bar is the shortest so far, so width = i.
			   //Else, the L bar has index stack.peek()+1, and R bar has index i-1. Therefore width = i-stack.peek()-1
			   int area = A[min] * (stack.isEmpty() ? i:(i - stack.peek()-1));
				maxArea = Math.max(maxArea, area);		
			}	
//			System.out.println("i = " + i + ", maxArea = " + maxArea + ",: " + stack);
		}
		
		while(!stack.isEmpty()){
			int min = stack.pop();
			int area = A[min] * (stack.isEmpty() ? i:(i - stack.peek()-1));
			maxArea = Math.max(maxArea, area);	
		}
		return maxArea;
	}
    public static void main(String[] args){
//    	int[] A = new int[]{2,1,5,6,2,3};
    	int[] A = new int[]{4,2};
    	LargestRectangleinHistogram s = new LargestRectangleinHistogram();
    	System.out.println(s.largestRectangleArea(A));
    	
    	
    }

}
