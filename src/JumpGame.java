
public class JumpGame {
//    public boolean canJump(int[] A) {
//    	int l = 0;
//    	int r = 0;
//    	int max = 0;
//    	while(r < A.length){
//    		for(int i=l;i<=r;i++){
//    			if(A[i] + i >= A.length-1)
//    				return true;
//    			if(A[i] + i > max)
//    				max = A[i] + i;
//    		}   		
//    		if(max == r) return false;
//    		l = r + 1;
//    		r = max;
//    	}
//    	return false;          
//    }
	public boolean canJump(int[] A){
		if(A == null) return false;
		int i = 0;//current index
		int max = 0;//max index can reach so far
		while(i < A.length && i <= max){
			max = Math.max(max, A[i]+i);//update max reachable index so far
			if(max >= A.length-1)//can reach the end of the array
				return true;
			i++;//else move to next index
		}
		return false;//cannot reach the end of the array 
	}
    
    public static void main(String[] args){
    	int[] A = new int[]{1,1,1,1,4};
//    	A = new int[]{2,3,1,1,4};
    	JumpGame solution = new JumpGame();
    	System.out.println(solution.canJump(A));
    }

}
