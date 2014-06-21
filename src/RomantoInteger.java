/**
 * [1,5,10,50,100,500,1000] = [I,V,X,L,C,D,M]
 * [1,2,3,4,5,6,7,8,9] = [I, II, III, IV, V, VI, VII, VIII, IX]
 * @author Weizheng
 *
 */
public class RomantoInteger {
	char[] one = new char[]{'I','X','C','M'};
	char[] five = new char[]{'V','L','D'};
	private int res = 0;
	public int romanToInt(String s) {
		
		int end = s.length();
		int d = 0;
		while(end > 0){
			int start = end ;		
			while(start >= 1 && (s.charAt(start-1) == one[d] || s.charAt(start-1) == five[d]))
				start--;
			res += aux(s.substring(start,end), d);
			d++;
//			System.out.println(start);
			end = start;
		}
		return res;
		
	}
	private int aux(String s, int d){
		System.out.println("s = " + s);
		int x = 0;
		String one = "" + this.one[d];
		String five = "" + this.five[d];
		if(s.equals(one))
			x = 1;
		else if(s.equals(one+one))
			x = 2;
		else if(s.equals(one+one+one))
			x = 3;
		else if(s.equals(one+five))
			x = 4;
		else if(s.equals(five))
			x = 5;
		else if(s.equals(five+one))
			x = 6;
		else if(s.equals(five+one+one))
			x = 7;
		else if(s.equals(five+one+one+one))
			x = 8;
		else if(s.equals(one + "" + this.one[d+1]))
			x = 9;
		
		return x * (int) Math.pow(10, d);
			
	}
	public static void main(String[] args){
		String s = "LXV";
		RomantoInteger solu = new RomantoInteger();
		System.out.println(solu.romanToInt(s));
		
	}
}
