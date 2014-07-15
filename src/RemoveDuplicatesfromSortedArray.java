import java.util.Arrays;


public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		if(A == null) return 0;
		if(A.length < 2) return A.length;		
		int preIndex = 0;//previous index
		for(int i=1;i<A.length;i++){
			if(A[i] != A[preIndex]){//does not equal to previous 
				A[++preIndex] = A[i];			
			}
		}
		return preIndex+1;//array length = preIndex + 1
	}

	public static void main(String[] args){
		int[] A = new int[]{1,2,2,3,3,5};	
		RemoveDuplicatesfromSortedArray  solution = new  RemoveDuplicatesfromSortedArray ();
		int b = solution.removeDuplicates(A);
		System.out.println("b = " + b + ", " + Arrays.toString(A));		
	}
}
