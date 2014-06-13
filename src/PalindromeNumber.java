
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		int t = x;
		int totalDigits = 0;
				
		while(t >0){
			t = t/10;
			totalDigits ++;
		}
		for(int i=1;i<=totalDigits/2;i++){
			if(pick(x,i) != pick(x,totalDigits - i + 1))
				return false;
			
		}
		return true;
	}
	private int pick(int x, int i){
		while(i > 1){
			x = x/10;
			i--;
		}
		return x%10;
	}
	
    
    public static void main(String[] args){
    	int x = 0;    
    	PalindromeNumber solution = new PalindromeNumber();
//    	solution.isPalindrome(x);
    	System.out.println(solution.isPalindrome(x));
    }

}
