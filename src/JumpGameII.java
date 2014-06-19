import java.util.Arrays;


public class JumpGameII {
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
	 * region [l,r] is the reachable region from A[0], with count steps
	 * in the for loop, we update the new reachable region, with count+1 steps 
	 * @param A
	 * @return
	 */
    public int jump(int[] A) {
    	if(A == null) return -1;
    	if(A.length == 1) return 1;
    	
    	int count = 0;
    	int l = 0;
    	int r = 0;
    	int max = 0;
    	while(r < A.length){
    		count ++;
    		for(int i=l;i<=r;i++){
    			if(A[i] + i >= A.length-1)
    				return count;
    			if(A[i] + i > max)
    				max = A[i] + i;
    		}
    		l = r+1;
    		r = max;
    		
    	}
    	return count;    	
    }
    
    public static void main(String[] args){
//    	int[] A = new int[]{1,4,3,2,1};
    	int[] A = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
    	JumpGameII solution = new JumpGameII();
    	System.out.println(solution.jump(A));   	
    }

}
