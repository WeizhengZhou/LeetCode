import java.util.*;
public class PermutationsII {
	public List<List<Integer>>  permuteUnique(int[] num) {
		if(num == null) return new ArrayList<List<Integer>>();
		boolean[] mark = new boolean[num.length];
		for(int i=0;i<num.length;i++)
			mark[i] = false;
			
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		helper(num, num.length, mark, list, lists);
		
		return lists;
	}
	private void helper(int[] num, int count, boolean[] mark, List<Integer> list, List<List<Integer>> lists){
		if(count == 0 && !lists.contains(list)){
			lists.add(new ArrayList<Integer>(list));
		}
		for(int i=0;i<num.length;i++){
			if(mark[i] == false){				
				mark[i] = true;;
				list.add(num[i]);				
				helper(num,count-1,mark,list,lists);
				mark[i] = false;
				list.remove( (Object) num[i]);//remove object, not remove index
			}
		}	
	}
	public static void main(String[] args){
		int[] A = new int[]{-1,2,0,-1,1,0,1};
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
