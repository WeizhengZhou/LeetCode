
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if(A == null) return 0;
		return helper(A, target, 0, A.length-1);
        
    }
	private int helper(int[] A, int target, int l, int r){
		if(l == r){
			if(target < A[l])
				return l;
			else
				return r+1;
		}
		else if(l+1 == r){
			if(target < A[l])
				return l;
			else if(target > A[r])
				return r+1;
			else
				return l+1;
		}
		else{
			int m = l + (r-l)/2;
			if(A[m] == target) return m;
			else if(target < A[m])
				return helper(A,target,l,m-1);
			else
				return helper(A,target,m+1,r);
		}
			
	}
	public static void main(String[] args){
		int[] A = new int[]{1,3};
		int target = 0;
		System.out.println(new SearchInsertPosition().searchInsert(A, target));
	}

}
