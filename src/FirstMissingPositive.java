import java.util.*;
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
    	int n = A.length;
    	BitSet bt = new BitSet(n);
    	for(int i=0;i<n;i++){
    		if(A[i] >0 && A[i] <= n){
    			bt.set(A[i]);
    		}
    	}
    	for(int i=1;i<=n;i++){
    		if(bt.get(i) == false){
    			return i;
    		}
    	}
    	return n+1;
        
    }
    public static void main(String[] ags){
//    	int[] A = new int[]{1,2,3,4};
//    	int[] A = new int[]{1,2,0};
    	int[] A = new int[]{3,4,1,-1};
    	
    	FirstMissingPositive solution = new FirstMissingPositive();
    	System.out.println(solution.firstMissingPositive(A));
    	
    }

}
