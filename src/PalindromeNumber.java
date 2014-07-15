
public class PalindromeNumber {
//	public boolean isPalindrome(int x) {
//		if(x < 0) return false;
//		int t = x;
//		int totalDigits = 0;
//				
//		while(t >0){
//			t = t/10;
//			totalDigits ++;
//		}
//		for(int i=1;i<=totalDigits/2;i++){
//			if(pick(x,i) != pick(x,totalDigits - i + 1))
//				return false;
//			
//		}
//		return true;
//	}
//	private int pick(int x, int i){
//		while(i > 1){
//			x = x/10;
//			i--;
//		}
//		return x%10;
//	}
	
	public boolean isPalindrome(int x) {
		if(x < 0) return false;//negative numbers are not palindrome, OJ requirement	
		int div = 10;//the smallest number of form 10^d that x/div = 0
		while(x/div > 0){//x = aaaa, div = 10,000			
			div *= 10;
		}
		div /= 10;
		while(x > 0){	
			int msd = x / div;//most significant digit
			int lsd = x % 10;//least significant digit
			System.out.println("x = " + x + ", div = " + div + ", msd = " + msd + ", lsd = " + lsd);
			if(msd != lsd)
				return false;
			x = x%div/10;//remove msd and lsd
			div = div/100;//two digits removed from x,
		}
		return true;
	}
	
    
    public static void main(String[] args){

    	int x = 1021;
//    	x = 1234321;
//    	x = Integer.MAX_VALUE;
//    	x = 121;
    	PalindromeNumber solution = new PalindromeNumber();
//    	solution.isPalindrome(x);
    	System.out.println(solution.isPalindrome(x));
    }

}
