import java.util.*;
public class PermutationsII {
	private List<List<Integer>> res = null;
	public List<List<Integer>> permuteUnique(int[] num) {
		this.res = new ArrayList<List<Integer>>();
		if(num == null) return this.res;
		helper(num,0);
		return res;
	}
	private void helper(int[] num, int d){	
		if(d == num.length){
			List<Integer> list  = new ArrayList<>();
			for(int i=0;i<num.length;i++)
				list.add(num[i]);
			res.add(list);
		}
		else{		
			Set<Integer> visited = new HashSet<>();
			for(int i=d;i<num.length;i++){
				if(!visited.contains(num[i])){//not visited before
					visited.add(num[i]);
					swap(num,d,i);
					helper(num,d+1);
					swap(num,d,i);	
				}
			}
		}
	}
	private void swap(int[] num, int p, int q){
		int temp = num[p];
		num[p] = num[q];
		num[q] = temp;
	}

	public static void main(String[] args){
		int[] A = new int[]{0,0,0,1,2};
		PermutationsII solution = new PermutationsII();
		List<List<Integer>> res = solution.permuteUnique(A);
		solution.printLists(res);		
	}
	private void printLists(List<List<Integer>> lists){
		for(List<Integer> list : lists){
			for(Integer i:list){
				System.out.print(i + ", ");
			}
			System.out.println();
		}
		
	}

}
