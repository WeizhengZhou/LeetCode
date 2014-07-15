
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s == null) return true;
		s = s.toLowerCase();
		int i = 0;
		int j = s.length()-1;
		while(i <= j){
			i = nextAlphaNumericIndex(s,i);
			j = preAlphaNumericIndex(s,j);						
			if(i >= j)//e.g. s = "   "
				return true;			
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	private int nextAlphaNumericIndex(String s, int i){
		//find the index of next alphanumeric character
		for(int k=i;k<s.length();k++){			
			if(isAlphaNumeric(s.charAt(k)))
				return k;
		}
		return s.length();
		
	}
	private int preAlphaNumericIndex(String s, int j){
		//find the index of previous alphanumeric character
		for(int k=j;k>=0;k--){
			if(isAlphaNumeric(s.charAt(k)))
				return k;
		}
		return 0;
	}
	private boolean isAlphaNumeric(char c){
		if(c <= 'z' && c >= 'a')
			return true;
		else if(c <= '9' && c >= '0')
			return true;
		else 
			return false;
	}
	public static void main(String[] args){
		String s = "A man, a plan, a canal: Panama";
//		s = "race a car";
//		s = "1a2";
	    ValidPalindrome solution = new  ValidPalindrome();
	    System.out.println(solution.isPalindrome(s));		
	}
	

}
