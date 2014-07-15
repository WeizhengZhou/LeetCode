import java.util.*;

public class PalindromePartitioning {

	private String s = null;
	private boolean[][] isPal = null;//isPal[i][j] = true if s[i...j] is a palindrome
	public List<List<String>> res = new ArrayList<List<String>>();
	public List<List<String>> partition(String s) {
		if(s == null) return res;	
		this.s = s;
		this.buildIsPalTable();
		List<String> list = new ArrayList<>();
		aux(0, list);
		return res;
	}
	private void buildIsPalTable(){
		int n = s.length();
		this.isPal = new boolean[n][n];
		for(int i=1;i<n;i++)
			isPal[i][i-1] = true;//empty string is palindrome
		for(int i=0;i<n;i++)
			isPal[i][i] = true;//single character is palindrome
		for(int len=2;len<=n;len++){//length from 2 to n
			for(int i=0;i<=n-len;i++){//i from 0 to n-1
				int j = i+len-1;
				if(s.charAt(i) == s.charAt(j)){
					isPal[i][j] = isPal[i+1][j-1];				
				}
			}
		}	
	}
	public void aux(int start, List<String> list){
		if(start == s.length()){
			res.add(new ArrayList<String>(list));
			return;
		}
		//partition the string into two parts, the first half is a palindrome
		for(int end=start;end < s.length();end++){
			if(isPal[start][end] == true){
				list.add(new String(s.substring(start, end+1)));
				aux(end+1, list);
				list.remove(list.size()-1);
			}
		}	
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
