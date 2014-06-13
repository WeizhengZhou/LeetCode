import java.util.Arrays;


public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) return 0;
		
		int b = 1;
		int last = A[0];
		for(int i=1;i<A.length;i++){
			if(A[i] != last){
				A[b++] = A[i];
				last = A[i];
			}
		}
		return b;

	}

	public static void main(String[] args){
		int[] A = new int[]{1,2,2,3,3,5};	
		RemoveDuplicatesfromSortedArray  solution = new  RemoveDuplicatesfromSortedArray ();
		int b = solution.removeDuplicates(A);
		System.out.println("b = " + b + ", " + Arrays.toString(A));
		
		
	}

}
