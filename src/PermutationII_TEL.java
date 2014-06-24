import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class PermutationsII_TEL {
	private int[] num = null;
	private Set<List<Integer>> set = new HashSet<>();
	private List<List<Integer>> lists = new ArrayList<List<Integer>>();
	private List<Integer> list = new ArrayList<>();
	private boolean[] mark = null;
	private int count = 0;	
	public List<List<Integer>> permuteUnique(int[] num) {
		if(num == null) return new ArrayList<List<Integer>>();
		this.num = num;
		this.mark = new boolean[num.length];		
		this.count = num.length;
		helper();
		return lists;
	}
	private void helper(){
		if(count == 0 && !set.contains(list)){
			List<Integer> r = new ArrayList<Integer>(list);
			lists.add(r);
			set.add(r);
		}
		for(int i=0;i<num.length;i++){
			if(mark[i] == false){				
				mark[i] = true;;
				list.add(num[i]);
				count--;
				helper();
				count++;	
				list.remove(list.size()-1);
				mark[i] = false;
			}
		}	
	}
	public static void main(String[] args){
		int[] A = new int[]{3,3,0,0,2,3,2};
		PermutationsII_TEL solution = new PermutationsII_TEL();
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
