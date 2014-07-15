
public class StringtoInteger_atoi {
	public int atoi(String s) {
		if(s == null) return 0;
		char[] A = s.toCharArray();
		int n = A.length;
		int index = 0;
		while(index < n && A[index] == ' ')//drop spaces
			index++;
		if(index == n) return 0;//index out of boundary	
		int sign = 1;//default plus
		if(A[index] == '+' || A[index] == '-'){//store sign of number
			sign = (A[index] == '+') ? 1:-1;
			index++;
		}
	
		int unsignNumber = 0;
		while(index < n && A[index] <= '9' && A[index] >= '0'){
			if( unsignNumber > Integer.MAX_VALUE/10 || 
					(unsignNumber == Integer.MAX_VALUE/10 && A[index] >= '8')){
				return (sign == 1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			else{
				unsignNumber  = unsignNumber * 10 + (A[index] - '0');
				index ++;
			}		
		}
		if(sign == 1) return unsignNumber;
		else return -unsignNumber;        
	}
	
	public static void main(String[] args){
//		System.out.println(Integer.MAX_VALUE);
		String s = "2147483647";
		s = "2147483648";
//		s = "-2147483649";
//		s = "-2147483645";
//		s = "      -11919730356x";
		StringtoInteger_atoi solu = new StringtoInteger_atoi();
		System.out.println(solu.atoi(s));
	}

}
