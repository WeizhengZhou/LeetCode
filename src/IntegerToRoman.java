/**
 * [1,5,10,50,100,500,1000] = [I,V,X,L,C,D,M]
 * [1,2,3,4,5,6,7,8,9] = [I, II, III, IV, V, VI, VII, VIII, IX]
 * @author Weizheng
 *
 */
public class IntegerToRoman {
	char[] one = new char[]{'I','X','C','M'};
	char[] five = new char[]{'V','L','D'};
	
	StringBuilder sb = new StringBuilder();
	public String intToRoman(int num) {
		int totalDigits = totalDigits(num);
		int d = totalDigits;
		int v = 0;
	
		while(num > 0){
			v = num/((int) Math.pow(10, d));
			aux(v,d);	
//			System.out.println(num + ", " + d + ", " + v);s
			num = num - v * (int) Math.pow(10, d);
			d--;
		}
		return sb.toString();
	}
	private int totalDigits(int num){
		int count = 0;
		while(num > 0){
			count++;
			num = num/10;
		}
		return count-1;	
	}
	
	private void aux(int v, int d){
		if(v <= 3){
			for(int i=1;i<=v;i++)
				sb.append(one[d]);
		}
		else if(v == 4){
			sb.append(one[d]);
			sb.append(five[d]);
		}
		else if(v == 5)
			sb.append(five[d]);
		else if(v <= 8){
			sb.append(five[d]);
			
			for(int i=6;i<=v;i++)
				sb.append(one[d]);
			
		}
		else{
			sb.append(one[d]);
			sb.append(one[d+1]);
		}
	}	
	public static void main(String[] args){
		int num = 3759;
		IntegerToRoman s = new IntegerToRoman();
		System.out.println(s.intToRoman(num));
		
	}
}
