import java.util.*;


public class Combinations {
//    public List<List<Integer>> combine(int n, int k) {
//    	List<Integer> list = new ArrayList<Integer>();
//		List<List<Integer>> lists = new ArrayList<List<Integer>>();		
//		
//		if(k > n) return lists;
//		helper(n, k, 1,list,lists);
//		return lists;
//        
//    }
//    private void helper(int n, int k, int start, List<Integer> list, List<List<Integer>> lists){
//    	if(n - start + 1 < k)//remaining numbers smaller than k
//    		return;
//    	if(k == 0){
//    		lists.add(new ArrayList<Integer>(list));    		
//    		return;
//    	}
//     	
//    	helper(n, k,   start+1, list, lists);
//    	list.add(start);
//    	helper(n, k-1, start+1, list, lists);
//    	list.remove(list.size()-1);
//    }
	
	   public List<List<Integer>> combine(int n, int k) {
	    	List<Integer> list = new ArrayList<Integer>();
			List<List<Integer>> lists = new ArrayList<List<Integer>>();
			int[] A = new int[n];
			for(int i=0;i<n;i++)
				A[i]=i+1;
			System.out.println(Arrays.toString(A));
			helper(A, k, 0, list, lists);
			return lists;
	        
	    }
	    private void helper(int[] A, int k, int start, List<Integer> list, List<List<Integer>> lists){
	 
	    	if(k == 0){
	    		lists.add(new ArrayList<Integer>(list));    		
	    		return;
	    	}
	    	else if(start >= A.length){
	    		return;
	    	}
	    	else{
	    		for(int i=start;i<A.length;i++){
	    			list.add(A[i]);
	    			helper(A,k-1,i+1,list,lists);
	    			list.remove(list.size()-1);
	    		}
	    	}   
	    }
	public static void main(String[] args){
		int n = 3;
		int k = 2;
	
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
