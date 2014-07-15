
/**
 * For any full columns, the odd ones have nRows characters, 
 * even ones have (nRows - 2) characters.
 * @author Weizheng
 *
 */
public class ZigZagConversion {	
	public String convert(String s, int nRows) {
		if(s == null || s.length() <2) return s;
		
		StringBuilder[] sbs = new StringBuilder[nRows];
		for(int i=0;i<nRows;i++)
			sbs[i] = new StringBuilder();
		
		int k = 0;		
		convert_odd(s,sbs,nRows,k);	
		
		StringBuilder res = new StringBuilder();
		for(StringBuilder sb:sbs){
			res.append(sb.toString());	
		}	
		return res.toString();
		
	}
	private void convert_odd(String s, StringBuilder[] sbs, int nRows, int k){	
		for(int i=0;i<nRows;i++){//from first row to last row, append to each row's stringbuilder
			sbs[i].append(s.substring(k,k+1));
			k++;//next element in s
			if(k >= s.length()) return;
		}
		convert_even(s,sbs,nRows,k);//go to even pattern	
	}
	private void convert_even(String s, StringBuilder[] sbs, int nRows, int k){
		for(int i= nRows-2;i>=1;i--){//reversed order, and omit first and last row
			sbs[i].append(s.substring(k,k+1));
			k++;//next element in s
			if(k >= s.length()) return;
		}
		convert_odd(s,sbs,nRows,k);//go to odd pattern		
	}

    public static void main(String[] args){
    	String s = "PAYPALISHIRING";
//    	String s = "ABCD";
    	ZigZagConversion solution = new ZigZagConversion();
    	System.out.println(solution.convert(s,3)); 
    }

}
