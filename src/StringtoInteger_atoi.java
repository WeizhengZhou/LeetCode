import java.util.Arrays;


public class StringtoInteger_atoi {
	public int atoi(String s) {
		if(s == null) return 0;
		
		char[] A = s.toCharArray();
		//------
//		System.out.println(Arrays.toString(A));
		int n = A.length;
		
		int index = 0;
		//discard pre-spaces
		while(index < n && A[index] == ' ')
			index++;
		//------
//		System.out.println("skip all spaces, index = " + index + ", " + A[index]);
		if(index == n) return 0;
		//index is not a space
		//if index is not a sign or not a number
		int sign = 0;
		if(A[index] == '+' || A[index] == '-'){
			sign = (A[index] == '+') ? 1:-1;
			index++;
		}
		else if(A[index] <= '9' && A[index] >= '0'){
			sign = 1;		
		}
		else
			return 0;
		//------
//		System.out.println("get sign, index = " + index + ", " + A[index]);
		
		while(A[index] == '0'){
			index++;
		}
		//------
//		System.out.println("first number is zero, index = " + index + ", " + A[index]);
		int unsignNumber = 0;
		while(index < n && A[index] <= '9' && A[index] >= '0'){
			if(Integer.MAX_VALUE/10 == unsignNumber && A[index] <='7'){
				int res = unsignNumber * 10 + (A[index] - '0');
				return (sign == 1) ? res : -res;
			}
			else if(Integer.MAX_VALUE/10 == unsignNumber){
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			else if(Integer.MAX_VALUE/10 < unsignNumber)
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			
			unsignNumber  = unsignNumber * 10 + (A[index] - '0');
			index ++;
			//------
//			System.out.println("compute number, index = " + index + ", " + A[index-1] + ", unsignNumber = " + unsignNumber);
		}
		if(sign == 1)
			return unsignNumber;
		else 
			return -unsignNumber;        
	}
	
	public static void main(String[] args){
		System.out.println(Integer.MAX_VALUE);
		String s = "2147483647";
		s = "2147483648";
		s = "-2147483649";
		s = "-2147483645";
		StringtoInteger_atoi solu = new StringtoInteger_atoi();
		System.out.println(solu.atoi(s));
	}

}
