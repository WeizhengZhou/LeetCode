import java.util.*;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		
		List<Integer> list = new ArrayList<Integer>();	
		list.add(1);
		if(rowIndex == 0) return list;
		for(int i=1;i<rowIndex;i++){			
			long cur = (long) list.get(i-1) * (long) (rowIndex -i +1) / (long) i;
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
