
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	if(num1 == null || num2 == null) return null;
    	if(num1.equals("0") || num2.equals("0")) return "0";
    	int n = num2.length();
    	String res = "";
    	
    	for(int i=n-1;i>=0;i--){
    		String t = num2.substring(i,i+1);
    		int d = n-i-1;
    		String b = multiply_helper(num1,t,d);
    		res = addition(res,b);
    	}
    	return res;
        
    }
    public String multiply_helper(String s, String c, int d){
    	if(s == null || c == null) return null;
    	if(Integer.parseInt(c) == 0) return "0";
    	StringBuilder sb = new StringBuilder();
    	int carry = 0;
    	int y = Integer.parseInt(c);
    	
    	for(int i =s.length()-1;i>=0;i--){
    		int x = Integer.parseInt(s.substring(i,i+1));
    		
    		int v = carry + x * y;
    		sb.append(v%10);
    		carry = v/10; 		
    	}
    	if(carry != 0)
    		sb.append(carry);
    	
    	sb.reverse();
    	
    	//append additional d zeros
    	for(int i=0;i<d;i++){
    		sb.append("0");
    	}	
    	return sb.toString();   	
    }
    public String addition(String a, String b){
    	if(a == null || b == null) return null;
    	int i = a.length() - 1;
    	int j = b.length() - 1;
    	int carry = 0;
    	StringBuilder sb = new StringBuilder();
    	while( i>= 0 || j >= 0){
    		if(i>=0){
    			carry += Integer.parseInt(a.substring(i,i+1));
    			i--;
    		}
    		if(j >= 0){
    			carry += Integer.parseInt(b.substring(j,j+1));
    			j--;
    		}
    		sb.append(carry%10);
    		carry = carry /10;
    	}
    	if(carry == 1) 
    		sb.append(1);
    	return sb.reverse().toString();
    	
    }
    public static void main(String[] args){
    	String a = "0";
    	String b = "1";
    	MultiplyStrings solution = new  MultiplyStrings();
//    	String res = solution.addition(a, b);
    	String res = solution.multiply(a, b);
    	System.out.println(res);
    	System.out.println(Integer.parseInt(a) * Integer.parseInt(b));
    	
    	
    }

}
