import java.util.Arrays;


public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if(A == null) return 0;
		if(A.length == 1) return 1;
		
		int preIndex = 0;
		int count = 1;
		
		for(int i=1;i<A.length;i++){
			if(A[i] != A[preIndex]){//found new number 
				A[++preIndex] = A[i];//set value
				count = 1;//set count = 1
			}
			else if(count < 2){//less than two 
				A[++preIndex] = A[i];
				count++;
			}
		}
		return preIndex+1;

	}
	public static void main(String[] args){
		int[] A = new int[]{1,1,1,2,2};
		RemoveDuplicatesfromSortedArrayII  s = new RemoveDuplicatesfromSortedArrayII();
		System.out.println(s.removeDuplicates(A));
		
	}
}
