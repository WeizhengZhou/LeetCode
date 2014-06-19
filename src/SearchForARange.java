import java.util.Arrays;


public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
    	int left = search_left(A,0,A.length-1,target);
    	int right = search_right(A,0,A.length-1,target);
    	return new int[]{left,right};
        
    }
    public int search_left(int[] A, int l, int r, int target){
    	if(l > r) return -1;
    	int m = (l+r)/2;
    	if(target == A[m]){
    		if(m == 0) return m;
    		else if(A[m-1] < target) return m;
    		else return search_left(A,l,m-1,target);		
    	}
    	else if(target < A[m])
    		return search_left(A,l,m-1,target);
    	else
    		return search_left(A,m+1,r,target);
    	
    }
    public int search_right(int[] A, int l, int r, int target){
    	if(l > r) return -1;
    	int m = (l+r)/2;
    	if(target == A[m]){
    		if(m == A.length-1) return m;
    		else if(A[m+1] > target) return m;
    		else return search_right(A,m+1,r,target);		
    	}
    	else if(target < A[m])
    		return search_right(A,l,m-1,target);	
    	else
    		return search_right(A,m+1,r,target);	   	
    }
    public static void main(String[] args){
    	int[] A = new int[]{1,5,8,8,8,9};
    	int target = 8;
    	SearchForARange solution = new SearchForARange();
    	int[] res  =solution.searchRange(A,8);
    	System.out.println(Arrays.toString(res));
    	
    	
    }
}
