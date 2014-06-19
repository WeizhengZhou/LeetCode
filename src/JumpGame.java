
public class JumpGame {
    public boolean canJump(int[] A) {
    	int l = 0;
    	int r = 0;
    	int max = 0;
    	while(r < A.length){
    		for(int i=l;i<=r;i++){
    			if(A[i] + i >= A.length-1)
    				return true;
    			if(A[i] + i > max)
    				max = A[i] + i;
    		}
    		
    		if(max == r) return false;
    		
    		l = r + 1;
    		r = max;
    	}
    	return false;
           
    }
    public static void main(String[] args){
    	int[] A = new int[]{3,2,1,0,4};
    	A = new int[]{2,3,1,1,4};
    	JumpGame solution = new JumpGame();
    	System.out.println(solution.canJump(A));
    }

}
