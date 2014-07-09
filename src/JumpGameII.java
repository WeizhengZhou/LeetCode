import java.util.Arrays;


public class JumpGameII {
	/**
	 * O(n^2) solution
	 */
//  public int jump(int[] A) {
//	if(A == null) return -1;
//	int[] L = new int[A.length];
//	L[A.length -1] = 0;
//	for(int i=A.length-2;i>=0;i--){
//		int j = i+1;
//		int min = Integer.MAX_VALUE;
//		while(j < A.length && (j-i) <= A[i]){
//			min = Math.min(min, 1+L[j]);
//			j++;
//		}
//		L[i] = min;
//	}
//	System.out.println(Arrays.toString(L));
//	return L[0];
//}
	/**
	 * O(n) solution
	 * @param A
	 * @return
	 */
    public int jump(int[] A) {
    	if(A == null) return -1;
    	if(A.length == 1) return 1;
    	
    	int l = 0;//reachable window [l,r]
    	int r = 0;
    	int nSteps = 0;//nSteps to reach window [l,r]
    	int curR = 0;//current reachable right boundary
    	while(r < A.length){
    		nSteps ++;//move one step
    		for(int i=l;i<=r;i++){//each starting position 
    			curR = Math.max(curR, A[i]+i);//update curR
    			if(curR >= A.length-1)//reach the end of array
    				return nSteps;
    		}
    		l = r+1;
    		r = curR;
    	}
    	return nSteps;    	
    }
    
    public static void main(String[] args){
//    	int[] A = new int[]{1,4,3,2,1};
    	int[] A = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
    	JumpGameII solution = new JumpGameII();
    	System.out.println(solution.jump(A));   	
    }

}
