import java.util.*;
public class CombinationSum {
	
    public List<List<Integer>> combinationSum(int[] cand, int target) {
    	if(cand == null) return null;
    	
    	Arrays.sort(cand);
    	List<Integer> list = new ArrayList<>();
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	  	
    	if(cand[0] > target) return lists;
    	
    	helper(cand,0,target,list,lists);
    	this.printLists(lists);
    	return lists;
        
    }
    public void helper(int[] cand, int k, int target, List<Integer> list, List<List<Integer>> lists) {
    	if(k > cand.length-1) return;
   
    	
    	System.out.println("k = " + k + ", target = " + target + " : " + list);
    	
    	if(target == 0 && !lists.contains(list)){		
    		lists.add(list);
    	}
    	if(target < cand[k])
    		return;
    	
    	
    	
    	List<Integer> la = new ArrayList<Integer>(list);
//    	List<Integer> lb = new ArrayList<Integer>(list);
    	List<Integer> lc = new ArrayList<Integer>(list);
    	
    	la.add(cand[k]);
//    	lb.add(cand[k]);
    	
    	helper(cand,k,  target-cand[k],la,lists);//include cand[k], and still want to add more cand[k]
    	helper(cand,k+1,target-cand[k],la,lists);//include cand[k], but does not want to add more cand[k]
    	helper(cand,k+1,target,        lc,lists);//does not include cand[k]
        
    }
    public static void main(String[] args){
    	int[] cand = new int[]{7,3,9,6};
    	int target = 6;
    	CombinationSum  solution = new CombinationSum ();
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
