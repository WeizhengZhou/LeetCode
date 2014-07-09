import java.util.Arrays;

/**
 * @see http://blog.csdn.net/zxzxy1988/article/details/8587244
 * @author Weizheng
 *
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int[] B) {
		if(A == null || B == null)
			return 0;
		int m = A.length;
		int n = B.length;
		if((m+n)%2 == 1)
			return kthSmallest(A,0,m-1,B,0,n-1,(m+n)/2 + 1);
		else
			return  (kthSmallest(A,0,m-1,B,0,n-1,(m+n)/2) + 
					kthSmallest(A,0,m-1,B,0,n-1,(m+n)/2+1))/ 2.0;
					
	}
	private int kthSmallest(int[] A, int la, int ra, int[] B, int lb, int rb, int k){
		if(la > ra)//empty A
			return B[lb+k-1];
		if(lb > rb)//empty B
			return A[la+k-1];
		if(ra -la > rb-lb)//assure A has shorter length
			return kthSmallest(B,lb,rb,A,la,ra,k);
		if(k == 1)//boundary condition, when k = 1, ka = 0, kb = 1, A[la+ka-1] is out of boundary
			return Math.min(A[la], B[lb]);
		
		int ka = (int) Math.min(ra-la+1, k/2);//need to compare with A's length		
		int kb = k - ka;//not kb = k/2

		if(A[la+ka-1] == B[lb+kb-1])
			return A[la + ka -1];
		else if(A[la+ka-1] < B[lb+kb-1])
			//A[start to la+ka-1] and B[lb+kb to end] are drop, not lb+kb-2, 
			//since B[lb+kb-1] might be the result
			return kthSmallest(A,la+ka,ra,B,lb,lb+kb-1,k-ka);
		else
			//A[la+ka to end] and B[start to lb+kb-1] are drop, not lb+kb-2
			return kthSmallest(A,la,la+ka-1,B,lb+kb,rb,k-kb);	
	}
	public static void main(String[] args){

		int[] A = new int[]{100001};
		int[] B = new int[]{100000};
		MedianOfTwoSortedArrays s = new MedianOfTwoSortedArrays();
		System.out.println(s.findMedianSortedArrays(A,B));
		
	}
}
