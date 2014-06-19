
public class CountandSay {
    public String countAndSay(int n) {
    	if(n == 0) return "1";
    	
    	return helper("1",0,n);
        
    }
    public String helper(String s, int k, int n){
    	if(k == n) return s;
    	
    	StringBuilder sb = new StringBuilder();
    	int i =0;   	
    	while(i<s.length()){
    		String t = s.substring(i,i+1);
    		int j = i+1;
    		while(j < s.length() && s.substring(j,j+1).equals(t)){
    			j++;
    		}
    		sb.append((j-i) + t);
    		i = j;
    	}
    	
    	return helper(sb.toString(), k+1, n);
    	
    }
    public static void main(String[] args){
    	String s = "1211";
    	CountandSay  solution = new CountandSay();
    	String res = solution.countAndSay(4);
    	System.out.println(res);
    }

}
