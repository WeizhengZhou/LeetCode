import java.util.*;

public class PalindromePartitioning {
	public List<List<String>> res = new ArrayList<List<String>>();
	public List<List<String>> partition(String s) {
		if(s == null)
			return res;
		List<String> list = new ArrayList<>();
		aux(s, 0, list);
		return res;

	}
	public void aux(String s, int start, List<String> list){
		if(start == s.length()){
			res.add(new ArrayList<String>(list));
			return;
		}
		//partition the string into two parts, the first half is a palindrome
		for(int end = start +1 ;end <= s.length(); end++){
			if(isPalindrome(s, start, end)){
				list.add(new String(s.substring(start, end)));
				aux(s, end, list);
				list.remove(list.size()-1);
			}
		}	
	}
	public boolean isPalindrome(String s, int start, int end){
		int i = start;
		int j = end-1;
		while(i <= j){
			if(!s.substring(i,i+1).equals(s.substring(j,j+1)))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args){
		String t = "abbacdc";
		PalindromePartitioning solution = new PalindromePartitioning ();
		List<List<String>> res = solution.partition(t);
		solution.print(res);
	}
	private void print(List<List<String>> res ){
		for(List<String> list : res){
			for(String s:list){
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
}
