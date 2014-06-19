
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
    	if(A == null) return false;
    	
    	return helper(A,0,A.length-1,target);
        
    }
    public boolean helper(int[] A,  int l, int r, int target){   	
    	if(l > r) return false;
    	int m = (l+r)/2;
    	if(target == A[m]) return true;


    	if(A[m] <= A[r]){
    		while(A[m] == A[r] && m < r)
    				m++;
    		if(target <= A[r] && target > A[m])
    			return helper(A,m+1,r,target);
    		else
    			return helper(A,l,m,target);
    	}
    	else{
    		while(A[m] == A[l] && m > l)
    				m--;
    		if(target < A[m] && target >= A[l])
    			return helper(A,l,m-1,target);
    		else
    			return helper(A,m,r,target);		
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
