import java.util.Arrays;

/**
 * @see http://blog.csdn.net/zxzxy1988/article/details/8587244
 * @author Weizheng
 *
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int[] B) {
//		if(A == null && B == null)
//			return 0;
		int m = A.length;
		int n = B.length;
		if((m+n)%2 == 1)
			return kthSmallest(A, 0, m-1, B, 0, n-1, (m+n)/2 + 1);
		else
			return  (kthSmallest(A, 0, m-1, B, 0, n-1, (m+n)/2) + 
					kthSmallest(A, 0, m-1, B, 0, n-1, (m+n)/2 + 1)) / 2.0;
					
	}
	private int kthSmallest(int[] A, int la, int ra, int[] B, int lb, int rb, int k){
		System.out.println("la = "  + la + ", ra = " + ra + ", lb = " + lb + ", rb = " + rb + ", k = " + k);
		if(la > ra) 
			return B[lb+k-1];
		if(lb > rb)
			return A[la+k-1];
		
		if(k == 1)
			return (int) Math.min(A[la], B[lb]);
		
		int lengthA = ra - la + 1;
		int lengthB = rb - lb + 1;
		
		if(lengthA > lengthB)
			return kthSmallest(B, lb, rb, A, la, ra, k);
		
		int ka = (int) Math.min(lengthA, k/2);
		
		int kb = k - ka;
		System.out.println("ka = " + ka + ", kb = " + kb);
		if(A[la + ka -1] == B[lb + kb -1])
			return A[la + ka -1];
		else if(A[la + ka -1] < B[lb + kb -1])
			return kthSmallest(A, la+ka, ra, B, lb, rb, k-ka);
		else
			return kthSmallest(A, la, ra, B, lb+kb, rb, k-kb);
		
	}
	public static void main(String[] args){

		int[] A = new int[]{1};
		int[] B = new int[]{2,3,4};
		MedianOfTwoSortedArrays s = new MedianOfTwoSortedArrays();
		System.out.println(s.findMedianSortedArrays(A,B));
		
	}

}
