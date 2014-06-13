
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null) return null;
    	if(strs.length <2) return "";
    	return helper(strs,0,strs.length -1);
        
    }
    private String helper(String[] strs, int l, int r){
    	if(l>r) return null;
    	else if(l == r) return strs[l];
    	else if(l+1 == r){
    		String a = strs[l];
    		String b = strs[r];
    		
    		int min = Math.min(a.length(), b.length());
    		int i =0;
    		while(i<min && a.charAt(i) == b.charAt(i)){
    			i++;
    		}
    		return a.substring(0,i);	
    	}
    	else{
    		int m = (l+r)/2;
    		String a = helper(strs,l,m);
    		String b = helper(strs,m+1,r);
    		return helper(new String[]{a,b},0,1);
    	}
    	
    }
    public static void main(String[] args){
    	String[] strs = new String[]{"abc","ac","a"};
    	LongestCommonPrefix s = new LongestCommonPrefix();
    	System.out.println(s.longestCommonPrefix(strs));
    }

}
