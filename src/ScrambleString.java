import java.util.*;
public class ScrambleString {
	private String s1 = null;
	private String s2 = null;
	public boolean isScramble(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		this.s1 = s1;
		this.s2 = s2;
		return aux(0, s1.length(), 0, s2.length());

	}
	private boolean aux(int l1, int r1, int l2, int r2){
		int n1 = r1 - l1;
		int n2 = r2 - l2;
		
		if(n1 != n2) return false;
		if(l1 > r1) return true;
		
		if(s1.substring(l1,r1).equals(s2.substring(l2,r2))) return true;
		
		int m1 = (l1+r1)/2;
		int m2 = (l2+r2)/2;
		
		char[] c1 = s1.substring(l1,m1).toCharArray();
		char[] c2l = s2.substring(l2,m2).toCharArray();
		char[] c2r = s2.substring(r2-n2/2,r2).toCharArray();
		Arrays.sort(c1);	
		Arrays.sort(c2l);
		Arrays.sort(c2r);
		String t1 = new String(c1);
		String t2l = new String(c2l);
		String t2r = new String(c2r);
		
		if(t1.equals(t2l)){
			return aux(l1,m1, l2, m2) && aux(r1-n1/2,r1, r2-n2/2, r2);
		}
		else{
			return aux(l1,m1, r2-n2/2, r2) && aux(r1-n1/2,r1,l2, m2);
			
		}
	}

}
