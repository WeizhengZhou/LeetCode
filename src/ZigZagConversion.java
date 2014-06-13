
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
		convert_1(s,sbs,nRows,k);	
		StringBuilder res = new StringBuilder();
		for(StringBuilder sb:sbs){
			res.append(sb.toString());	
		}	
		print(sbs);
		return res.toString();
		
	}
	private void convert_1(String s, StringBuilder[] sbs, int nRows, int k){	
		for(int i=0;i<nRows;i++){
			sbs[i].append(s.substring(k,k+1));
			k++;
			if(k > s.length()-1)
				return;
		}
		convert_2(s,sbs,nRows,k);	
	}
	private void convert_2(String s, StringBuilder[] sbs, int nRows, int k){
		for(int i= nRows-2;i>=1;i--){
			sbs[i].append(s.substring(k,k+1));
			k++;
			if(k > s.length()-1)
				return;
		}
		convert_1(s,sbs,nRows,k);			
	}

    public static void main(String[] args){
    	String s = "PAYPALISHIRING";
//    	String s = "ABCD";
    	ZigZagConversion solution = new ZigZagConversion();
    	System.out.println(solution.convert(s,3));
    
    }
    private void print(StringBuilder[] sbs){
    	for(StringBuilder sb:sbs){
    		String t = sb.toString();
    		for(int i=0;i<t.length();i++){
    			System.out.print(t.substring(i,i+1) + " ");
    		}
    		System.out.println("");
    	}
    }
	

}
