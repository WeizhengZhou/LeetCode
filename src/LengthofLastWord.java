
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
    	int end = preNonSpace(s,s.length()-1);
    	int start = preSpace(s,end);
    	
    	return end - start;
        
    }
    private int preNonSpace(String s, int k){
    	while(k>=0){
    		if(!s.substring(k,k+1).equals(" "))
    			break;
    		k--;
    	}
    	return k;
    }
    private int preSpace(String s, int k){
    	while(k >= 0){
    		if(s.substring(k,k+1).equals(" "))
    			break;
    		k--;
    	}
    	return k;
    }
    public static void main(String[] args){
    	String s = "Hello World";
    	s = "     ";
    	LengthofLastWord solution = new LengthofLastWord();
    	System.out.println(solution.lengthOfLastWord(s));
    }

}
