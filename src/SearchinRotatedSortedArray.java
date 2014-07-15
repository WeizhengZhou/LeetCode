
public class SearchinRotatedSortedArray {
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
    	else{//right half sorted
    		if(target <= A[r] && target > A[m])//search right half
    			return helper(A,m+1,r,target);
    		else//search left half
    			return helper(A,l,m-1,target);
    	}   	
    }
    public static void main(String[] args){
    	int[] A = new int[]{4,5,1,2,3};
    	int target = 3;
    	SearchinRotatedSortedArray solution = new SearchinRotatedSortedArray();
    	int res = solution.search(A, target);
    	System.out.println(res);  	
    }
}
