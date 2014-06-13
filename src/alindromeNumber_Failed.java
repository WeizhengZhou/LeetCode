
public class PalindromeNumber_Failed {
	public boolean isPalindrome(int x) {
		if(x == Integer.MIN_VALUE) return false;
		x = Math.abs(x);
		System.out.println(x);
		return isPal(x);
		
	}	
    private boolean isPal(int x) {
    	
    	int n = nDigits(x);
    	if(n <= 1) return true;
    	else{
    		int least = x%10;
    		int temp = ((int) Math.pow(10, n-1));
    		int most = x / temp;
    		System.out.println("x =" + x + ", least = " + least + ", most = " + most);
    		if(least != most)
    			return false;
    		else{
    			x = (x - most * temp)/10;
    			System.out.println("x = " + x);
    			return isPal(x); 			
    		}   			
    	}
    }
    private int nDigits(int x){
    	int n = 0;
    	while(x > 0){
    		x = x/10;
    		n++;
    	}
    	return n;
    }
    public static void main(String[] args){
    	int x = 1221;
//    	x = -2147483648; was failed at Integer.min_value;
    	x = 10000021;//failed at this test case
      
    	PalindromeNumber solution = new PalindromeNumber();
    	System.out.println(solution.isPalindrome(x));
    }

}
