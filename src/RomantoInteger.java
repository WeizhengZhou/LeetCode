/**
 * [1,5,10,50,100,500,1000] = [I,V,X,L,C,D,M]
 * [1,2,3,4,5,6,7,8,9] = [I, II, III, IV, V, VI, VII, VIII, IX]
 * @author Weizheng
 *
 */
public class RomantoInteger {
	
	public int romanToInt(String s) {
		if(s == null) return 0;
		int i = s.length()-1;
		int res = 0;
		while(i >= 0){
			int cur = charToNum(s.charAt(i));
			if(i == 0) {				
				res += cur;
				return res;
			}
			else{
				int pre = charToNum(s.charAt(i-1));
				if(pre >= cur){//previous >= current I,II,III,V,VI,VII,VIII
					res += cur;
					i--;
				}
				else{
					res = res + cur - pre;//IV, IX
					i=i-2;
				}				
			}		
		}
		return res;			
	}
	private int charToNum(char c){
		switch(c){
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default: return 0;
		}	
	}
	
	public static void main(String[] args){
		String s = "MMMDCCLIX";
		RomantoInteger solu = new RomantoInteger();
		System.out.println(solu.romanToInt(s));
		
	}
}
