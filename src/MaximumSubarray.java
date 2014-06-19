
public class MaximumSubarray {
	 public int maxSubArray(int[] A) {
		 int cur = 0;
		 int max = 0;
		 for(int i=0;i<A.length;i++){
			 cur += A[i];
			 if(cur > max)
				 max = cur;
			 if(cur < 0)
				 cur =0;
		 }
		 return max;
	        
	 }
	 public static void main(String[] args){
		 int[] A = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		 MaximumSubarray solution = new MaximumSubarray();
		 System.out.println(solution.maxSubArray(A));
	 }

}
