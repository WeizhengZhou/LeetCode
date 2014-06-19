
import java.util.*;
public class GrayCode {
	public List<Integer> grayCode(int n) {
		if(n == 0) {
		   	List<Integer> list = new ArrayList<Integer>();
		   	list.add(0);
		   	return list;
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		
		for(int i=1;i<n;i++){
			List<Integer> l1 = new ArrayList<>(list);
			List<Integer> l2 = new ArrayList<>();
 			for(int j=list.size()-1;j>=0;j--){
 				l2.add(l1.get(j) + (1 << i));
			}
 			l1.addAll(l2);
 			list = l1;
		}
//		printBinary(list);
		return list;
	}
	public static void main(String[] args){
		GrayCode s = new GrayCode();
		System.out.println(s.grayCode(3));	
	}
	private void printBinary(List<Integer> list){
		for(Integer e:list){
			System.out.println(e + ", "+ Integer.toBinaryString(e));
		}
	}
	

}
