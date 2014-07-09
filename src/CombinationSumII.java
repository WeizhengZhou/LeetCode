import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CombinationSumII {
	public List<List<Integer>> combinationSum(int[] cand, int target) {	
		List<Integer> list = new ArrayList<>();		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(cand == null) 
			return lists;
		Arrays.sort(cand);

		helper(cand,0, target,list,lists);
		this.printLists(lists);
		return lists;       
	}
	private void helper(int[] cand, int k, int target, List<Integer>list, List<List<Integer>> lists){
		if(target < 0) 
			return;
		else if(target == 0){
			lists.add(new ArrayList<>(list));//remember create a new list, otherwise, list will finally be empty
			return;
		}
		else{ 
			for(int i=k;i<cand.length;i++){
				if(cand[i] > target) break;
				list.add(cand[i]);
				helper(cand,i+1,target-cand[i],list,lists);
				list.remove(list.size()-1);
				while(i<cand.length-1 && cand[i] == cand[i+1])
					i++;						
			}
		}	
	}
    public static void main(String[] args){
//    	int[] cand = new int[]{1,1,2};
//    	int target = 2;
    	int[] cand = new int[]{10,1,2,7,6,1,5};
    	int target = 8;
    	CombinationSumII  solution = new CombinationSumII();
    	solution.combinationSum(cand, target);   	
    }
    private void printLists(List<List<Integer>>  lists){
    	for(List<Integer> list:lists){
    		for(Integer a : list){
    			System.out.print(a + ", ");
    		}
    		System.out.println();
    	}
    	
    }
}
