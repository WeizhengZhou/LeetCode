import java.util.*;

public class PascalsTriangleII {
	public List<Integer> getRow(int n) {		
		List<Integer> list = new ArrayList<Integer>();	
		list.add(1);
		for(int k=1;k<n;k++){			
			long cur = (long) list.get(k-1) * (long) (n -k +1) / (long) k;
			list.add((int) cur);	
		}
		list.add(1);
		return list;
	}
	public static void main(String[] args){
		PascalsTriangleII s = new PascalsTriangleII ();
		System.out.println(s.getRow(30));
	}
}
