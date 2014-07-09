import java.util.*;
public class CombinationSum {	

//	public List<List<Integer>> combinationSum(int[] cand, int target) {	
//		List<Integer> list = new ArrayList<>();		
//		List<List<Integer>> lists = new ArrayList<List<Integer>>();
//		if(cand == null) 
//			return lists;
//		Arrays.sort(cand);
//		helper(cand,0, target,list,lists, 0);
//		return lists;       
//	}
//	private void helper(int[] cand, int index, int target, List<Integer>list, List<List<Integer>> lists, int level){
//		System.out.println("(" + index + ", " + target + ")");
//	
//		if(target < 0) 
//			return;
//		else if(target == 0){
//			lists.add(new ArrayList<>(list));//remember create a new list, otherwise, list will finally be empty
//			return;
//		}
//		else if(index >= cand.length)
//			return;
//		else if(cand[index] <= target){
//			String format = new String(new char[2*(level+1)]).replace("\0", "   ");
//	    	
//			System.out.print(format + "|______A ");
//			helper(cand,index+1,target,list,lists,level+1);
//			
//			list.add(cand[index]);
//			System.out.print(format + "|______B ");	
//			helper(cand,index,target-cand[index],list,lists,level+1);
//			
//			System.out.print(format + "|______C ");
//			helper(cand,index+1,target-cand[index],list,lists,level+1);
//			
//			list.remove(list.size()-1);		
//		}		
//	}
	

	public List<List<Integer>> combinationSum(int[] cand, int target) {	
		List<Integer> list = new ArrayList<>();		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(cand == null) 
			return lists;
		Arrays.sort(cand);
		helper(cand,0, target,list,lists);
		return lists;       
	}
	private void helper(int[] cand, int index, int target, List<Integer>list, List<List<Integer>> lists){
		System.out.println("(" + index + ", " + target + ")");	
		if(target < 0) 
			return;
		else if(target == 0){
			lists.add(new ArrayList<>(list));//remember create a new list, otherwise, list will finally be empty
			return;
		}
		else{
			for(int i=index;i<cand.length;i++){
				if(cand[i] > target) break;//no valid solutions anymore 
				list.add(cand[i]);
				helper(cand,i,target-cand[i],list,lists);//still can use cand[i]
				list.remove(list.size()-1);//remember to remove
			}
		}
	}
    public static void main(String[] args){

    	int[] cand = new int[]{3,6};
    	int target = 6;
    	CombinationSum  solution = new CombinationSum ();
    	List<List<Integer>> lists = solution.combinationSum(cand, target);
//    	solution.printLists(lists); 
    	
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
