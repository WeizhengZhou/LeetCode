
public class ReverseWordsInString {
	public String reverseWords(String t){
		if(t == null) return null;	
	    StringBuilder sb = new StringBuilder();
	    
	    int end = t.length();//end of a word
	    int start;//start of a word	   
	    while(true){
	    	//terminate when s.substring(end-1,end) is not a space
	    	while(end > 0 && t.substring(end-1,end).equals(" "))
	    		end--;
	        	
	    	if(end <= 0)//if no words any more, exit loop
	    		break;
	    	
	    	//find the start of the word
	    	start = end;
	    	//terminate when s.substring(start-1,start) is a space
	    	while(start >= 0 && !t.substring(start-1,start).equals(" "))
	    		start --;
	    	
	    	sb.append(t.substring(start,end) + " ");
	    	end = start;
	    }
	    String res = sb.toString();
	    //in case the res is empty, for example input is "    "
	    if(res.length() == 0)
	    	return "";
	    else
	        return res.substring(0,res.length()-1);//remove the last space
	    	
	}
	public static void main(String[] args){
		String t = " the sky is blue ";
//		String t = "   ";
		for(int i=0;i<t.length();i++){
			System.out.println(i + ": " + t.substring(i,i+1));
		}
		System.out.println( "#" + new ReverseWordsInString().reverseWords(t) + "#");
	}
	

}
