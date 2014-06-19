import java.util.*;


public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
    	List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		if(k > n) return lists;
		
		helper(n, k, 1,list,lists);
		return lists;
        
    }
    private void helper(int n, int k, int cur, List<Integer> list, List<List<Integer>> lists){
    	if(n - cur + 1 < k)
    		return;
    	
    	if(k == 0){
    		lists.add(new ArrayList<Integer>(list));    		
    		return;
    	}
    
    	
    	helper(n, k,   cur+1, list, lists);
    	list.add(cur);
    	helper(n, k-1, cur+1, list, lists);
    	list.remove((Integer) cur);
    }
	public static void main(String[] args){
		int n =4;
		int k =2;
	
		Combinations solution = new  Combinations();
		List<List<Integer>> res = solution.combine(n,k);
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
