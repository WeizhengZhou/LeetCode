import java.util.*;
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(numRows <= 0) return lists;
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		lists.add(l1);
		if(numRows == 1) return lists;
				
		for(int i=2;i<=numRows;i++){
			List<Integer> pre = lists.get(lists.size()-1);
			List<Integer> cur = new ArrayList<>();
			cur.add(1);
			for(int j=1;j<pre.size();j++){
				cur.add(pre.get(j-1) + pre.get(j));
			}
			cur.add(1);
			lists.add(cur);
		}
		return lists;
	}
	public static void main(String[] args){
		int numRows = 5;
		PascalsTriangle s = new PascalsTriangle();
		List<List<Integer>> lists = s.generate(numRows);	
		s.print(lists);
	}
	private void print(List<List<Integer>> lists){
		for(List<Integer> list : lists){
			for(Integer e: list){
				System.out.print(e + ", ");
			}
			System.out.println();
		}
	}
}
