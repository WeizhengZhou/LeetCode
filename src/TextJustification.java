import java.util.*;
public class TextJustification {
	private List<String> res = new ArrayList<>();
	public List<String> fullJustify(String[] words, int length) {
		aux(words, 0, length);
		return res;
	}
	private void aux(String[] words, int start, int L){
		if(start == words.length) return;
		
		int wordsLength = 0;//length of non-space characters
		int spacesLength = L;//length of spaces
		int nWords = 0;//number of words in this line
		
		int end = start;//include as many words as we can
        //                          words length so fat + this word's length + number of spaces		                          
		while(end < words.length && (wordsLength + words[end].length() + (end - start)) <= L ){
			wordsLength += words[end].length();
			spacesLength -= words[end].length();
			nWords++;
			end++;
		}
		//format this line
		StringBuilder sb = new StringBuilder();
		if(nWords == 1){//one word line, append word, then append spaceLength spaces
			sb.append(words[start]);
			for(int i=0;i<spacesLength;i++)
				sb.append(" ");
		}
		else if(end < words.length){//not the last line
			int spacesPerWord = spacesLength / (nWords - 1);//each space slots has at least spacesPerWord
			int extraSpaces= spacesLength - spacesPerWord * (nWords -1);//extra spaces for first x slots
			for(int i=start;i<end-1;i++){//append words and spaces
				sb.append(words[i]);//append word
				for(int j=0;j<spacesPerWord;j++)//append spaces
					sb.append(" ");
				if(extraSpaces > 0){//if has extra spaces remaining 
					sb.append(" ");
					extraSpaces--;
				}				
			}
			sb.append(words[end-1]);//append last word
		}
		else{//end == words.length, this is the last line
			for(int i=start;i<end-1;i++){
				sb.append(words[i]);
				sb.append(" ");
			}
			sb.append(words[end-1]);//last word does not append space		
			int remainSpaces = L - wordsLength - (end -start - 1);
			while(remainSpaces > 0){
				sb.append(" ");
				remainSpaces--;		
			}			
		}
		res.add(sb.toString());
		aux(words, end, L);	//next line
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
