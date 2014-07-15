
import java.util.*;
public class NextPermutation {
	public void nextPermutation(int[] num){
		if(num == null || num.length < 2) return;			
		int p = num.length-2;
		while(p >= 0 && num[p] >= num[p+1])//>= not >
			p--;
		int l = p+1;//when p=-1, l=0
		int r = num.length-1;
		while(l < r){//change from descending order to ascending order
			swap(num,l,r);
			l++;
			r--;
		}
		if(p >= 0){//swap A[p] and A[q]
			for(int i=p+1;i<num.length;i++){
				if(num[i] > num[p]){//find the smallest number larger than A[p]
					swap(num, p, i);
					break;
				}
			}
		}
//		System.out.println(p);
	}
	private void swap(int[] A, int p, int q){
		int temp = A[p];
		A[p] = A[q];
		A[q] = temp;
	}

	public static void main(String[] args){
		int[] num = new int[]{5,1,1};
		NextPermutation solution = new NextPermutation();
		solution.nextPermutation(num);
		System.out.println(Arrays.toString(num));
		
	}

}
