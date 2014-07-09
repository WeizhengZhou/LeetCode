
public class MultiplyStrings {
//    public String multiply(String num1, String num2) {
//    	if(num1 == null || num2 == null) return null;
//    	if(num1.equals("0") || num2.equals("0")) return "0";
//    	int n = num2.length();
//    	String res = "";
//    	
//    	for(int i=n-1;i>=0;i--){
//    		String t = num2.substring(i,i+1);
//    		int d = n-i-1;
//    		String b = multiply_helper(num1,t,d);
//    		res = addition(res,b);
//    	}
//    	return res;
//        
//    }
//    public String multiply_helper(String s, String c, int d){
//    	if(s == null || c == null) return null;
//    	if(Integer.parseInt(c) == 0) return "0";
//    	StringBuilder sb = new StringBuilder();
//    	int carry = 0;
//    	int y = Integer.parseInt(c);
//    	
//    	for(int i =s.length()-1;i>=0;i--){
//    		int x = Integer.parseInt(s.substring(i,i+1));
//    		
//    		int v = carry + x * y;
//    		sb.append(v%10);
//    		carry = v/10; 		
//    	}
//    	if(carry != 0)
//    		sb.append(carry);
//    	
//    	sb.reverse();
//    	
//    	//append additional d zeros
//    	for(int i=0;i<d;i++){
//    		sb.append("0");
//    	}	
//    	return sb.toString();   	
//    }
//    public String addition(String a, String b){
//    	if(a == null || b == null) return null;
//    	int i = a.length() - 1;
//    	int j = b.length() - 1;
//    	int carry = 0;
//    	StringBuilder sb = new StringBuilder();
//    	while( i>= 0 || j >= 0){
//    		if(i>=0){
//    			carry += Integer.parseInt(a.substring(i,i+1));
//    			i--;
//    		}
//    		if(j >= 0){
//    			carry += Integer.parseInt(b.substring(j,j+1));
//    			j--;
//    		}
//    		sb.append(carry%10);
//    		carry = carry /10;
//    	}
//    	if(carry == 1) 
//    		sb.append(1);
//    	return sb.reverse().toString();
//    	
//    }
	public String multiply(String a, String b) {
//		System.out.println(a + ", " + b);	
		if(a == null || b == null) return null;
		if(a.equals("") || b.equals("")) return "";
		if(a.equals("0") || b.equals("0")) return "0";		
		int m = a.length();
		int n = b.length();
		if(m + n < 9){
			return "" + Integer.parseInt(a) * Integer.parseInt(b);
		}
		else{
			String aLbL = multiply(a.substring(0,m/2), b.substring(0,n/2));
			String aLbR = multiply(a.substring(0,m/2), b.substring(n/2,n));
			String aRbL = multiply(a.substring(m/2,m), b.substring(0,n/2));
			String aRbR = multiply(a.substring(m/2,m), b.substring(n/2,n));
			System.out.println(a + ", " + b + ", " + aLbL + ", " + aLbR + ", " + aRbL + ", " + aRbR);			
			String res = aLbL + new String(new char[m-m/2+n-n/2]).replace('\0', '0');
			res = addition(res, aLbR + new String(new char[m-m/2]).replace('\0','0'));
			res = addition(res, aRbL + new String(new char[n-n/2]).replace('\0','0'));
			res = addition(res, aRbR);
			return res;
		}
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
