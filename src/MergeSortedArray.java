import java.util.*;
public class MergeSortedArray {
	 public void merge(int A[], int m, int B[], int n) {
		 int i = m-1;
		 int j = n-1;
		 int k = m+n-1;
		 while(i >= 0 || j >= 0){
			 if(i < 0)
				 A[k--] = B[j--];				 
			 else if(j < 0)
				 A[k--] = A[i--];
			 else if(A[i] > B[j])
				 A[k--] = A[i--];
			 else
				 A[k--] = B[j--];			
		 }
	 }
	 public static void main(String[] args){
		 int[] A = new int[]{1,2,3,0,0,0};
		 int[] B = new int[]{4,5};
		 int m = 3;
		 int n = 2;
		 MergeSortedArray s = new MergeSortedArray();
		 s.merge(A, m, B, n);
		 System.out.println(Arrays.toString(A));
		 
	 }
}
