import java.util.*;

import javax.swing.event.ListSelectionEvent;
public class FourSum {
	
	public List<List<Integer>> fourSum(int[] A, int target) {
		if(A == null || A.length < 4) return new ArrayList<List<Integer>>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Arrays.sort(A);
		for(int i=0;i<A.length-3;i++){
			for(int j=i+1;j<A.length-2;j++){
				int l = j+1;
				int r = A.length-1;
				while(l < r){					
					int sum = A[i] + A[j] + A[l] + A[r];
//					System.out.println("i = " + i + ", j = " + j + ", l = " + l + ", r = " + r + ", sum = " + sum);	        		
					if(sum == target){
						List<Integer> list = new ArrayList<>();
						list.add(A[i]);
						list.add(A[j]);
						list.add(A[l]);
						list.add(A[r]);
						lists.add(list);
						while(l < r && A[l] == A[l+1]) l++;//skip duplicate result
						while(r > l && A[r] == A[r-1]) r--;//skip duplicate result
						l++;//need to move one more step
						r--;
					}
					else if(sum < target) l++;
					else r--;
				}
				while(j < A.length-1 && A[j] == A[j+1]) j++;//skip duplicate result
			}
			while(i < A.length-1 && A[i] == A[i+1]) i++;//skip duplicate result
		}
		return lists;
	}


	public static void main(String[] args){
//		int[] num = new int[]{1, 0, -1, 0, -2, 2};
		int[] num = new int[]{-3, -3,-2,-1,0,0,1,2,3};
;		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(num));
		FourSum solution = new FourSum();
		solution.print(solution.fourSum(num,0));



	}
	private void print(List<List<Integer>> lists){
		for(List<Integer> list : lists){
			for(Integer i:list){
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}


}
