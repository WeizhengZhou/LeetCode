import java.util.Arrays;


public class DecodeWays {
	public int numDecodings(String s) {
		if(s == null) return 0;
		int n = s.length();
		if(n == 0) return 0;
		if(s.substring(0,1).equals("0")) return 0;//special case s = "0, 
		int[] L = new int[n+1];//L[i] is the number of decoding ways of s[0...i-1];
		
		L[0] = 1;//empty string
		L[1] = 1;//non zero start string's first digit
		
		for(int i=2;i<n+1;i++){
			int preDigit = Integer.parseInt(s.substring(i-2,i-1));//previous digit
			int curDigit = Integer.parseInt(s.substring(i-1,i));//cur digit		
			L[i] = 0;
			if(curDigit != 0)//if curDigit can be parsed
				L[i] += L[i-1];
			if(preDigit == 1)//if 10<=preDigt*10 + curDigit <=19
				L[i] += L[i-2];
			else if(preDigit == 2 && curDigit <=6)// 20<=preDigt*10 + curDigit <=26
				L[i] +=L[i-2];
		}
		return L[n];
	}
	public static void main(String[] args){
		String s = "121";
		DecodeWays solu = new DecodeWays();
		System.out.println();
		System.out.println(solu.numDecodings(s));
	}

}
