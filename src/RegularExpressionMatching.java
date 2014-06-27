
public class RegularExpressionMatching {
	public boolean isMatch(String A, String B) {
		if(A == null && B == null) return true;
		if(A == null && B != null) return false;
		if(A != null && B == null) return false;
		 A = convert(A);
		 B = convert(B);
		 System.out.println(A);
		 System.out.println(B);
		 
		 int[][] L = new int[A.length()/2][B.length()/2];
		 
		 int i = A.length()-1;
		 int j = B.length()-1;
		 while(i >= 0 && j >= 0){
			 String a = A.substring(i-1,i);
			 String b = B.substring(j-1,j);			 
			 String aCount = A.substring(i,i+1);
			 String bCount = B.substring(j,j+1);
			 if(!matchChar(a,b) && matchCount(aCount,bCount))
				 return false;
			 else if(){
				 
			 }
			 if(matchChar(a,b) && matchCount(aCount,bCount)){
				 i=i-2;
				 j=j-2;
			 }
			 else
				 return false;	 
		 }
		 int k = (i>=0)?i:j;
		 String C = (i>=0)?A:B;
		 while(k>=0){
			 String c = C.substring(k-1,k);
			 String cCount = C.substring(k,k+1);
			 if(cCount.equals("*")){
				 k=k-2;			 
			 }
			 else
				 return false;	 
			 
		 }
		 return true;
	}
	private boolean matchChar(String a, String b){
		if(a.equals(".") || b.equals(".") || a.equals(b))
			return true;
		else 
			return false;
	}
	private boolean matchCount(String aCount, String bCount){
		if(aCount.equals("*") || bCount.equals("*") || aCount.equals(bCount))
			return true;
		else return false;
	}
	public String convert(String s){
		if(s == null) return null;
		if(s.equals("*")) 
			return "*";		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < s.length()){	
			String cur = s.substring(i,i+1);//cur != "*"
			assert !cur.equals("*");
			if(i == s.length()-1){
				sb.append(cur + 1);
				break;			
			}					
			if(s.substring(i+1,i+2).equals("*")){
				sb.append(cur+"*");
				i=i+2;
			}
			else{
				int j = i+1;
				while(j<s.length() && s.substring(j,j+1).equals(cur)){
					j++;
				}
				sb.append(cur+(j-i));	
				i = j;						
			}
		}
		return sb.toString();
	}
	public static void main(String[] args){
		String A = "c..a*b";
		String B = "c..b";
		RegularExpressionMatching solu = new RegularExpressionMatching();
		System.out.println(solu.isMatch(A, B));
	
		
	}

}
