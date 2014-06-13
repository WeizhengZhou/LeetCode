
public class ReverseWordsInString {
	public String reverseWords(String t){
		//guard extreme case
		if(t == null) return null;	
		//use string builder for efficiency
	    StringBuilder sb = new StringBuilder();
	    
	    int start = t.length();//start of a word
	    int end = t.length();//end of a word
	    while(true){
	    	//find the previous non-space index
	    	while(end > 0 && t.substring(end-1,end).equals(" ")){
	    		end --;
	    	}
	    	//if no such space, exit loop
	    	if(end <= 0) break;
	    	//find the previous space index
	    	start = end;
	    	while(start >0 && !t.substring(start-1,start).equals(" ")){
	    		start --;
	    	}
//	    	if(start < 0) break;
	    	//append word and a space
	    	sb.append(t.substring(start,end) + " ");
	    	end = start;
	    
	    }
	    String res = sb.toString();
	    //in case the res is empty, for example input is "    "
	    if(res.length() == 0)
	    	return "";
	    else
	        return res.substring(0,res.length()-1);//remove the last possible space
	    	
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
