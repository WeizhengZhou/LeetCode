
public class ImplementstrStr {
    public String strStr(String haystack, String needle) {
    	if(haystack == null || needle == null) return null;
    	if(needle == "") return haystack;
    	
    	int m = haystack.length();
    	int n = needle.length();
    	if(m < n) return null;
    	
    	
    	for(int i=0;i<m-n+1;i++){
//    		System.out.println("i = "+ i + ", " + haystack.substring(i,i+n));
    		if(haystack.substring(i,i+n).equals(needle))
    			return haystack.substring(i);
    	}
    	return null;   
    }
    public static void main(String[] args){
    	String haystack = "aaaa";
    	String needle = "a";
    	ImplementstrStr solution = new ImplementstrStr();
    	System.out.println(solution.strStr(haystack, needle));
    }
}
