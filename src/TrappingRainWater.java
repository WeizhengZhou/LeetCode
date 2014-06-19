
public class TrappingRainWater {
    public int trap(int[] A) {
    	if(A == null || A.length <3) return 0;
    	int water = 0;
    	int left = 0;
    	int right = 0;
    	while(left < A.length-1){
    		right = findRightBar(A,left);
    		int level =  Math.min(A[left], A[right]);
    		for(int i =left+1;i<right;i++){
    			if(level > A[i]){
    				water += level - A[i];
    			}
    		}
    		System.out.println("l = " + left + ", r = " + right + ", level = " + level + ", water = " + water);  		
    		left = right;
    	}
    	return water;       
    }
    /**
     * find the right bar
     * the right bar should be the highest peak on the right
     * if it is higher than left bar, then returns
     * @param A
     * @param left
     * @return
     */
    
    private int findRightBar(int[] A, int left){
    	int cur = left;
    	int right = -1;
    	int peak = -1;
    	while(cur < A.length-1){
    	    peak = findNextPeak(A,cur);
    		if(A[peak] >= A[left]) return peak;
    		
    		if(right == -1)
    			right = peak;   		
    		else if(A[peak] > A[right])
    			right = peak;
    		
    		cur = peak;
    	}
    	return right;
    	
    }
    /**
     * find a peak on the right of cur
     * @param A
     * @param cur
     * @return
     */
    private int findNextPeak(int[] A, int cur){
    	cur = cur + 1;
		while(cur < A.length-1){
			if((A[cur-1] < A[cur] && A[cur+1] <= A[cur]))
				break;
			else
			    cur++;
		}
		return cur; 	
    }
    public static void main(String[] ags){
//    	int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//    	int[] A = new int[]{5,2,1,2,1,5};
    	int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    	TrappingRainWater solution = new TrappingRainWater();
    	System.out.println(solution.trap(A));
    }

}
