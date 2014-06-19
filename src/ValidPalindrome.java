
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s == null) return true;
		s = s.toLowerCase();
		int i = 0;
		int j = s.length()-1;
		while(i <= j){
			int a = nextAlpha(s,i);
			int b = preAlpha(s,j);
			
			//guard for "   " like string
			if(a > b)
				return true;
			
			if(!s.substring(a,a+1).equals(s.substring(b,b+1)))
				return false;
			i = a + 1;
			j = b - 1;			
		}
		return true;
		

	}
	private int nextAlpha(String s, int i){
		for(int k=i;k<s.length();k++){
			String t = s.substring(k,k+1);
			if(t.compareTo("z") <= 0 && t.compareTo("a") >= 0)
				return k;
			//alhanumeric string, not only alpha
			if(t.compareTo("9") <= 0 && t.compareTo("0") >= 0)
				return k;
		}
		return s.length();
		
	}
	private int preAlpha(String s, int j){
		for(int k=j;k>=0;k--){
			String t = s.substring(k,k+1);
			if(t.compareTo("z") <= 0 && t.compareTo("a") >= 0)
				return k;
			if(t.compareTo("9") <= 0 && t.compareTo("0") >= 0)
				return k;
		}
		return 0;
	}
	public static void main(String[] args){
		String s = "A man, a plan, a canal: Panama";
		s = "race a car";
		s = "1a2";
	    ValidPalindrome solution = new  ValidPalindrome();
	    System.out.println(solution.isPalindrome(s));		
	}
	

}
