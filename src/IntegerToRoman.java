/**
 * [1,5,10,50,100,500,1000] = [I,V,X,L,C,D,M]
 * [1,2,3,4,5,6,7,8,9] = [I, II, III, IV, V, VI, VII, VIII, IX]
 * @author Weizheng
 *
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
		if(num > 3999) return "";
		StringBuilder sb = new StringBuilder();
		int d = 0;
		while(num > 0){
			int cur = num % 10;
			sb.append(aux(cur,d));
			num /=10;
			d++;
		}	
		return sb.reverse().toString();			
	}
	private String[] one = new String[]{"I","X","C","M"};
	private String[] five = new String[]{"V","L","D"};
	/**
	 * return number cur at digit d
	 * Note string are reverse, e.g. cur = 4, d =1 return VI
	 * @param cur
	 * @param d
	 * @return
	 */
	private String aux(int cur, int d){
		switch(cur) {
		case 0: return "";
		case 1: return one[d];
		case 2: return one[d]+one[d];
		case 3: return one[d]+one[d]+one[d];
		case 4: return five[d] + one[d];
		case 5: return five[d];
		case 6: return one[d] + five[d];
		case 7: return one[d]+one[d]+five[d];
		case 8: return one[d]+one[d]+one[d]+five[d];
		case 9: return one[d+1]+one[d];
		default: return "";
		}
	}
	public static void main(String[] args){
//		int num = 3759;
		int num = 3999;
		IntegerToRoman s = new IntegerToRoman();
		System.out.println(s.intToRoman(num));
		for(int i=1;i<=10;i++){
				
			System.out.println(s.intToRoman(i));
		}	
	}
}
