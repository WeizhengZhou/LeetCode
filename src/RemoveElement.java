import java.util.Arrays;


public class RemoveElement {
    public int removeElement(int[] A, int elem) {
    	int end = 0;//end of the array   
    	for(int i=0;i<A.length;i++){
    		if(A[i] != elem){//only place numbers not equal to elem
    			A[end++] = A[i];
    		}
    	}
    	return end;//length of the array      
    }
    public static void main(String[] args){
    	int[] A = new int[]{1,2,3,4,2};
    	int elem = 2;
    	RemoveElement solution = new RemoveElement();
    	int end = solution.removeElement(A, elem);
    	System.out.println("new length = " + end + ", "+ Arrays.toString(A));
    }

}
