
public class MultiplyStrings {

	public String multiply_DivideConquer(String a, String b) {
		if(a == null || b == null) return null;
		if(a.equals("") || b.equals("")) return "";
		if(a.equals("0") || b.equals("0")) return "0";		
		int m = a.length();
		int n = b.length();
		if(m + n < 9){
			return "" + Integer.parseInt(a) * Integer.parseInt(b);
		}
		else{
			//a*b = (aL*10^(m+1)/2 + aR) * (bL*10^(n+1)/2 + bR)
			//    = aL*bL*10^(m-m/2+n-n/2) + aL*bR *10^(m-m/2) + ...
			String aLbL = multiply(a.substring(0,m/2), b.substring(0,n/2));
			String aLbR = multiply(a.substring(0,m/2), b.substring(n/2,n));
			String aRbL = multiply(a.substring(m/2,m), b.substring(0,n/2));
			String aRbR = multiply(a.substring(m/2,m), b.substring(n/2,n));
			//add all results
			String res = aLbL + new String(new char[m-m/2+n-n/2]).replace('\0', '0');//append additional zeros
			res = addition(res, aLbR + new String(new char[m-m/2]).replace('\0','0'));
			res = addition(res, aRbL + new String(new char[n-n/2]).replace('\0','0'));
			res = addition(res, aRbR);
			return res;
		}
	}
	
	public String multiply(String a, String b) {
		if(a == null || b == null) return null;
		int m = a.length();
		int n = b.length();	
		
		String res = "";//final result
		for(int i=m-1;i>=0;i--){
			StringBuilder sb = new StringBuilder();
			for(int k=0;k<m-i-1;k++){//append zeros
				sb.append("0");
			}
			int carry = 0;
			for(int j=n-1;j>=0;j--){
			    carry += Integer.parseInt(a.substring(i,i+1)) * Integer.parseInt(b.substring(j,j+1));
				sb.append(carry%10);
				carry /= 10;
			}
			if(carry == 1)
				sb.append(1);
			res = addition(res, sb.reverse().toString());				
		}	
		
		int start = 0;//start nonzero index
		while(start < res.length() && res.charAt(start) == '0')//trim front zeros
			start++;
		return start == res.length() ? "0":res.substring(start);
	}
	
	public String addition(String a, String b){
		if(a == null || b == null) return null;
		StringBuilder sb = new StringBuilder();
		int i = a.length()-1;
		int j = b.length()-1;
		int carry = 0;
		while(i >=0 || j>=0){
			if(i >= 0){
				carry += Integer.parseInt(a.substring(i,i+1));
				i--;
			}
			if(j >= 0){
				carry += Integer.parseInt(b.substring(j,j+1));
				j--;
			}
			sb.append(carry%10);
			carry /=10;
		}
		if(carry == 1)
			sb.append(1);
		return sb.reverse().toString();
	}
	
    public static void main(String[] args){
    	String a = "332620029"; 
    	String b = "0";
    	MultiplyStrings solution = new  MultiplyStrings();
//    	String res = solution.addition(a, b);
//    	System.out.println(Integer.parseInt(a) * Integer.parseInt(b));
    	
    	String res = solution.multiply(a, b);    	
    	System.out.println(res);
    	System.out.println(Integer.parseInt(a) * Integer.parseInt(b));
    	   	
    }
}
