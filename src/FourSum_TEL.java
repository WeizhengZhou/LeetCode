import java.util.*;

import javax.swing.event.ListSelectionEvent;
public class FourSum_TEL {
	public class Pair{
		int x = 0;
		int y = 0;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	List<List<Integer>> lists = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> FourSum_TEL(int[] A, int target) {
		
		Map<Integer, List<Pair>> map = new HashMap<>();
		
		if(A == null || A.length < 4) return lists;
		Arrays.sort(A);
		
		for(int i=0;i<A.length;i++){
			for(int j=i;j<A.length;j++){
				int sum = A[i] + A[j];
				Pair p = new Pair(A[i],A[j]);			
				if(!map.containsKey(sum)){
					List<Pair> index = new ArrayList<>();
					index.add(p);
					map.put(sum, index);				
				}else{
					List<Pair> index = map.get(sum);
					index.add(p);
					map.put(sum, index);		
				}					
			}		
		}
		Set<Integer> keySet = map.keySet();
		for(Integer s1 : keySet){
			for(Integer s2: keySet){
				if(s1 + s2 == target){
					if(s1 == s2){
						List<Pair> l = map.get(s1);
						aux_1(l);						
					}
					else{
						List<Pair> l1 = map.get(s1);
						List<Pair> l2 = map.get(s2);
						aux_2(l1,l2);
					}			
				}
			}
		}				
		return lists;

	}
	private void aux_1(List<Pair> list){
		if(list.size() == 1) return;
		for(int i=0;i<list.size()-1;i++){
			for(int j=i;j<list.size();j++){
				Pair p1 = list.get(i);
				Pair p2 = list.get(j);
				List<Integer> t = new ArrayList<>();
				t.add(p1.x);
				t.add(p1.y);
				t.add(p2.x);
				t.add(p2.y);
				Collections.sort(t);
				lists.add(t);
			}
		}	
	}
	private void aux_2(List<Pair> l1, List<Pair> l2){
		
		for(int i=0;i<l1.size()-1;i++){
			for(int j=0;j<l2.size();j++){
				Pair p1 = l1.get(i);
				Pair p2 = l2.get(j);
				List<Integer> t = new ArrayList<>();
				t.add(p1.x);
				t.add(p1.y);
				t.add(p2.x);
				t.add(p2.y);
				Collections.sort(t);
				lists.add(t);
			}
		}	
	}
	   public static void main(String[] args){
		   int[] num = new int[]{1, 0, -1, 0, -2, 2};
	    	Arrays.sort(num);
	    	System.out.println(Arrays.toString(num));
	    	FourSum_TEL solution = new FourSum_TEL();
	    	solution.print(solution.FourSum_TEL(num,0));
		 
	    	
	    	
	    }
	    private void print(List<List<Integer>> lists){
	    	for(List<Integer> list : lists){
	    		for(Integer i:list){
	    			System.out.print(i + ", ");
	    		}
	    		System.out.println();
	    	}
	    }
	

}
