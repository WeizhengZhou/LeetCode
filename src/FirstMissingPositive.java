import java.util.*;
/**
 *  move all numbers in the range [1 ... A.length] to its correct position, 
 *  i.e. number i to position i-1.  
 * @author Weizheng
 *
 */
public class FirstMissingPositive {
//    public int firstMissingPositive(int[] A) {
//    	int n = A.length;
//    	BitSet bt = new BitSet(n);
//    	for(int i=0;i<n;i++){
//    		if(A[i] >0 && A[i] <= n){
//    			bt.set(A[i]);
//    		}
//    	}
//    	for(int i=1;i<=n;i++){
//    		if(bt.get(i) == false){
//    			return i;
//    		}
//    	}
//    	return n+1;      
//    }
	
	public int firstMissingPositive(int[] A){
		if(A == null) return 1;//empty array, first missing 1
		int n = A.length;
		for(int i=0;i<n;i++){
			int k = A[i]-1;//A[i]'s correct index 
			while(k >= 0 && k < n && k != A[k]-1){//A[k] is not in the right position
				int next = A[k]-1;//A[k]'s correct index
				A[k] = k+1;//move A[i] to A[k]
				k = next;//set next 
				System.out.println(Arrays.toString(A));
			}
		}		
		for(int i=0;i<n;i++){//find first incorrect number
			if(A[i] != i+1)
				return i+1;
		}
		return n+1;
	}
    public static void main(String[] ags){
    	int[] A = new int[]{1,2,3,4};
//    	int[] A = new int[]{1,2,0};
//    	int[] A = new int[]{3,4,1,-1};
    	
    	FirstMissingPositive solution = new FirstMissingPositive();
    	System.out.println(solution.firstMissingPositive(A));
    	
    }
}
