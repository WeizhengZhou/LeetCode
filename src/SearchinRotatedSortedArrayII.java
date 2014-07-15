
public class SearchinRotatedSortedArrayII {
	public int search(int[] A, int target) {
    	if(A == null) return -1;
    	return helper(A,0,A.length-1,target);       
    }
    public int helper(int[] A,  int l, int r, int target){   	
    	if(l > r) return -1;
    	int m = (l+r)/2;
    	if(target == A[m]) return m;
    	else if(A[m] > A[l]){//left half sorted
    		if(target < A[m] && target >= A[l])//search left half
    			return helper(A,l,m-1,target);
    		else//search right half
    			return helper(A,m+1,r,target);		    	
    	}
    	else if(A[m] < A[l]){//right half sorted
    		if(target <= A[r] && target > A[m])//search right half
    			return helper(A,m+1,r,target);
    		else//search left half
    			return helper(A,l,m-1,target);
    	} 
    	else{//A[l] is not the target, search next
    		return helper(A,l+1,r,target);
    	}
    }
    		
    public static void main(String[] args){
    	int[] A = new int[]{1,1,3,1};
    	int target = 3;
    	SearchinRotatedSortedArrayII solution = new SearchinRotatedSortedArrayII();
    	boolean res = solution.search(A, target);
    	System.out.println(res);    	
    }

}
