import java.util.Arrays;


public class RemoveElement {
    public int removeElement(int[] A, int elem) {
    	int b = 0;
    	int n = A.length;
    	for(int i=0;i<n;i++){
    		if(A[i] != elem){
    			A[b++] = A[i];
    		}
    	}
    	return b;
        
    }
    public static void main(String[] args){
    	int[] A = new int[]{1,2,3,4,2};
    	int elem = 4;
    	RemoveElement solution = new RemoveElement();
    	int b = solution.removeElement(A, elem);
    	System.out.println("new length = " + b + ", "+ Arrays.toString(A));
    }

}
