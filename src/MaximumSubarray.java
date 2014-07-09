
public class MaximumSubarray {
	 public int maxSubArray(int[] A) {
		 int curSum = 0;
		 int maxSum = 0;
		 for(int i=0;i<A.length;i++){
			 curSum += A[i];
			 curSum = Math.max(curSum, 0);
			 maxSum = Math.max(maxSum,curSum);
		 }
		 return maxSum;        
	 }
	 public int maxSubArray_DivideConquer(int[] A){
		 if(A == null) return 0;
		 return helper(A, 0, A.length-1);
		 
	 }
	 private int helper(int[] A, int l, int r){
		 if(l > r) return Integer.MIN_VALUE;
		 if(l == r) return A[l];
		 int m = l + (r-l)/2;
	
		 int max = Math.max(helper(A,l,m), helper(A,m+1,r));
	
		 int i = m;
		 int lSum = 0;
		 int lMax = 0;	 		 
		 while(i >= l){
			 lSum += A[i];
			 lMax = Math.max(lMax,lSum);
			 i--;
		 }
		 i = m+1;
         int rSum = 0;
         int rMax = 0;
		 while(i <= r){
			 rSum += A[i];
			 rMax = Math.max(rMax,rSum);
			 i++;
		 }		 
		 return Math.max(max, lMax+rMax);
	 }
	 
	 public static void main(String[] args){
		 int[] A = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		 MaximumSubarray solution = new MaximumSubarray();
		 System.out.println(solution.maxSubArray(A));
		 System.out.println(solution.maxSubArray_DivideConquer(A));
	 }

}
