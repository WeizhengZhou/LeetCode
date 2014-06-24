
public class SearchinRotatedSortedArrayII {
	private int[] A = null;
	private int target;
	
    public boolean search(int[] A, int target) {
    	if(A == null) return false;
    	this.A = A;
    	this.target = target;
    	return helper(0,A.length-1);
    	
    }
    public boolean helper(int l, int r){   	
    	if(l > r) return false;
    	int m = (l+r)/2;
    	if(target == A[m]) return true;
    	if(A[m] > A[l]){
    		if(target < A[m] && target >= A[l])
    			return helper(l, m-1);
    		else
    			return helper(m+1,r);
    	}
    	else if(A[m] < A[r]){
    		if(target <= A[r] && target > A[m])
    			return helper(m+1,r);
    		else
    			return helper(l,m-1);   		
    	}
    	else if(A[m] == A[l]){
    		l++;
    		while(l < A.length && A[l] == A[l-1])
    			l++;
    		return helper(l, r);
    	}
    	else{
    		r--;
    		while(r >= 0 && A[r] == A[r+1])
    			r--;
    		return helper(l,r);
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
