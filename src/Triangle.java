import java.util.*;

public class Triangle {
	public int minimumTotal(List<List<Integer>> t) {
		if(t == null || t.size() == 0) return -1;
		
		if(t.size() == 1)//t only has one level
			return t.get(0).get(0);
			
		List<Integer> curSum = new ArrayList<Integer>();//minimal sum to this level		
		curSum.add(t.get(0).get(0) + t.get(1).get(0));
		curSum.add(t.get(0).get(0) + t.get(1).get(1));
		
		List<Integer> nextSum = new ArrayList<Integer>();		
		for(int i=2;i<t.size();i++) {
			List<Integer> list = t.get(i);
			nextSum.add(curSum.get(0) + list.get(0));//j = 0, only one path
			for(int j=1;j<curSum.size();j++){
				nextSum.add(Math.min(curSum.get(j-1), curSum.get(j)) + list.get(j));
			}
			nextSum.add(curSum.get(curSum.size()-1) + list.get(list.size()-1));//j = end, only one path
			curSum = new ArrayList<>(nextSum);
			nextSum.clear();
		}
		return Collections.min(curSum);
	}
	public static void main(String[] args){
		List<List<Integer>> t = new ArrayList<List<Integer>>();
		List<Integer> l0 = new ArrayList<>();
		l0.add(2);
		t.add(l0);
		
		List<Integer> l1 = new ArrayList<>();
		l1.add(3);
		l1.add(4);
		t.add(l1);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(6);
		l2.add(5);
		l2.add(7);
		t.add(l2);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(4);
		l3.add(1);
		l3.add(8);
		l3.add(3);
		t.add(l3);
		
		Triangle s = new Triangle();
		System.out.println(s.minimumTotal(t));
		
		
	}
}
