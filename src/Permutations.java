
import java.util.*;
public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		if(num == null) return new ArrayList<List<Integer>>();
		Set<Integer> mark = new HashSet<Integer>(num.length);
		for(int i=0;i<num.length;i++){
			mark.add(num[i]);
		}
		
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		helper(num,mark,list,lists);
		
		return lists;
	}
	public void helper(int[] num, Set<Integer> mark, List<Integer> list, List<List<Integer>> lists){
//		System.out.println(mark + ", " + list);
		if(mark.isEmpty()){
			lists.add(new ArrayList<Integer>(list));
		}
		for(int i=0;i<num.length;i++){
			if(mark.contains(num[i])){
				
				mark.remove(num[i]);
				list.add(num[i]);
				
				helper(num,mark,list,lists);
				
				mark.add(num[i]);
				list.remove( (Object) num[i]);//remove object, not remove index
			}
		}	
	}
	public static void main(String[] args){
		int[] A = new int[]{1,2,3};
		Permutations solution = new Permutations();
		List<List<Integer>> res = solution.permute(A);
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
