import java.util.*;

public class PalindromePartitioning {
	private List<List<String>> = new ArrayList<List<String>>();
	public List<List<String>> partition(String s) {

	}
	private List<String> aux(String s, int i, int j){
		if(i >= j) 
			return null;
		List<String> list = new ArrayList<>();
		if(i == j-1) {
			list.add(s.substring(i,i+1));
			return list;
		}
		for(int k=i+1;k<j;k++){
			List<String> left = aux(s, i, k);
			
		}
		
	}
}
