import java.util.*;
public class TextJustification {
	private List<String> res = new ArrayList<>();
	public List<String> fullJustify(String[] words, int length) {
		aux(words, 0, length);
		return res;
	}
	private void aux(String[] words, int start, int L){
		if(start == words.length)
			return;
		int end = start;	
		int wordsLength = 0;
		int spacesLength = L;
		int nWords = 0;
		
		while(end < words.length && (wordsLength + words[end].length() + (end - start)) <= L ){
			wordsLength += words[end].length();
			spacesLength -= words[end].length();
			nWords++;
			end++;
		}
		StringBuilder sb = new StringBuilder();
		if(nWords == 1){
			sb.append(words[start]);
			for(int i=0;i<spacesLength;i++)
				sb.append(" ");
		}
		else if(end < words.length){//a normal line
			int spacesPerWord = spacesLength / (nWords - 1);//nWords - 1 slots of spaces
			int extraSpaces= spacesLength - spacesPerWord * (nWords -1);//extra spaces to put after the first word
//			System.out.println("start = " + start + ", end = " + end + ", wordsLength = " + wordsLength + ", spacesLength = " + spacesLength + ", nWords = " + nWords + ", spacesPerWord = " + spacesPerWord);
			for(int i=start;i<end-1;i++){//not include the end 
				sb.append(words[i]);
				for(int j=0;j<spacesPerWord;j++)
					sb.append(" ");
				if(extraSpaces > 0){
					//extra spaces are given to each word from first to last, until it runs out
					sb.append(" ");
					extraSpaces--;
				}
					
			}
			sb.append(words[end-1]);
		}
		else{//end == words.length, this is the last line
			for(int i=start;i<end-1;i++){
				sb.append(words[i]);
				sb.append(" ");
			}
			sb.append(words[end-1]);//last word does not append space
			
			
			int remainSpaces = L - wordsLength - (end -start-1);
			while(remainSpaces > 0){
				sb.append(" ");
				remainSpaces--;		
			}			
		}
		res.add(sb.toString());
		aux(words, end, L);	//go to next line
	}

	public static void main(String[] args){
//		String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//		String[] words = new String[]{"1234567890","ccccccccc"};
//		String[] words = new String[]{""};
//		String[] words = new String[]{"What","must","be","shall","be", "ccc."};
		String[] words = new String[]{"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it"};
		
		int length = 30; 
		TextJustification solu = new TextJustification();
		List<String> res = solu.fullJustify(words, length);
		for(String s : res)
			System.out.println("["+s+"]" + s.length());
	}

}
