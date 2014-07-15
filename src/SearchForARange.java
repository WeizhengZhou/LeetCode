import java.util.Arrays;


public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
    	int leftBoundary = search(A,0,A.length-1,target,true);//search left boundary
    	int rightBoundary = search(A,0,A.length-1,target,false);//search right boundary
    	return new int[]{leftBoundary,rightBoundary};       
    }
    public int search(int[] A, int l, int r, int target, boolean isLeftBoundary){
    	if(l > r) return -1;
    	int m = l + (r-l)/2;
    	if(target < A[m])
    		return search(A,l,m-1,target,isLeftBoundary);
    	else if(target > A[m])
    		return search(A,m+1,r,target,isLeftBoundary);
    	else if(isLeftBoundary){//search left boundary
    		if(m==0 || A[m-1] < target)//found left boundary
    			return m;
    		else
    			return search(A,l,m-1,target,isLeftBoundary);//search left half
    	}   	
    	else{
    		if(m == A.length-1 || A[m+1] > target)//found right boundary
    			return m;
    		else
    			return search(A,m+1,r,target,isLeftBoundary);//search right half		
    	}
    }

    public static void main(String[] args){
    	int[] A = new int[]{8,8,8,8,8,8};
    	int target = 8;
    	SearchForARange solution = new SearchForARange();
    	int[] res  =solution.searchRange(A,8);
    	System.out.println(Arrays.toString(res));
    	
    	
    }
}
