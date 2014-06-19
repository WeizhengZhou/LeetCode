import java.util.*;
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		if(S == null) return lists;
		Arrays.sort(S);
		helper(S,0,list,lists);
		return lists;
	}
	private void helper(int[] S, int k, List<Integer> list, List<List<Integer>> lists){
		if(k == S.length){			
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		helper(S,k+1,list,lists);
		list.add(S[k]);
		helper(S,k+1,list,lists);
		list.remove((Integer) S[k]);
	}
	public static void main(String[] args){
		int[] S = new int[]{3,2,1};
		Subsets solution = new Subsets();
		List<List<Integer>> res = solution.subsets(S);
		solution.print(res);
		
		
	}
	private void print(List<List<Integer>> lists){
		for(List<Integer> list : lists){
			for(int e:list){
				System.out.print(e+", ");
			}
			System.out.println();
		}
	}

}
