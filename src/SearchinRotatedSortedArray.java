
public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
    	if(A == null) return -1;
    	
    	return helper(A,0,A.length-1,target);
        
    }
    public int helper(int[] A,  int l, int r, int target){   	
    	if(l > r) return -1;
    	int m = (l+r)/2;
    	if(target == A[m]) return m;
//    	System.out.println("l = " + l + ", r = " + r + ", m = "+ m);	
    	if(A[l] < A[r]){
    		if(target < A[m])
    			return helper(A,l,m-1,target);
    		else
    			return helper(A,m+1,r,target);
    	}
    	else if(A[m] < A[r]){
    		if(target <= A[r] && target > A[m])
    			return helper(A,m+1,r,target);
    		else
    			return helper(A,l,m-1,target);
    	}
    	else{
    		if(target < A[m] && target >= A[l])
    			return helper(A,l,m-1,target);
    		else
    			return helper(A,m+1,r,target);		
    	}
    }
    public static void main(String[] args){
    	int[] A = new int[]{4,5,1,2,3};
    	int target = 1;
    	SearchinRotatedSortedArray solution = new SearchinRotatedSortedArray();
    	int res = solution.search(A, target);
    	System.out.println(res);
    	
    }

}
