import java.util.ArrayList;
import java.util.List;
public class TextJustification_Failed {
	private List<String> res = new ArrayList<>();
	public List<String> fullJustify(String[] words, int length) {
		aux(words, 0, length);
		return res;
	}
	private void aux(String[] words, int i, int L){
		if(i == words.length)
			return;	
		int j = i;
		int nWords = 0;
		int wordsLength = 0;//length of nonspace characters in this line
		
		//find j such that words[i..j] are in this line
		while(j < words.length && (wordsLength + words[j].length() + nWords) <= L){
			wordsLength += words[j].length();
			nWords++;
			j++;			
		}		
	    j--;//either j == words.length or including this j will exceed L
		
//		System.out.println("i = " + i + ", j = " + j);
		
		int totalSpaces = L - wordsLength;//total number of spaces in this line
		
		int spacesPerWord = 0;//spaces between words not the first one
		int spaceAfterFirstWord = 0;//spaces after the first word
		int spaceAfterLastWord = 0;//space after the last word
		
		if(j == words.length - 1){//last line 
			spacesPerWord = 1;//
			spaceAfterFirstWord = 1;	
			spaceAfterLastWord = L - wordsLength - (nWords-1);
		}
		else if(nWords == 1){
			spaceAfterFirstWord = L - wordsLength;
		}
		else{
			spacesPerWord = totalSpaces/(nWords-1);	
			int extraSpaces =  L - wordsLength - (nWords-1) * spacesPerWord ;
			spaceAfterFirstWord = extraSpaces + spacesPerWord;		
		}
		System.out.println("i = " + i + ", j = " + j + ", nWords = " + nWords + ", wordsLength = " + wordsLength +", totalSpaces = " + totalSpaces + ", spacePerWord = " + spacesPerWord);
		StringBuilder sb = new StringBuilder();
		sb.append(words[i]);
		while(spaceAfterFirstWord > 0){
			sb.append(" ");
			spaceAfterFirstWord--;
		}
		for(int k=i+1;k<=j;k++){
			sb.append(words[k]);
			if(k != j){
				for(int t=0;t<spacesPerWord;t++){
					sb.append(" ");
				}	
			}				
		}
		while(spaceAfterLastWord > 0){
			sb.append(" ");
			spaceAfterLastWord--;
		}
		res.add(sb.toString());	
//		System.out.println("i = " + i + ", j = " + j + ": [" + res.get(res.size()-1)+"]" + res.get(res.size()-1).length());
		aux(words, j+1, L);				
	}
	public static void main(String[] args){
//		String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//		String[] words = new String[]{"1234567890","ccccccccc"};
		String[] words = new String[]{""};
//		String[] words = new String[]{"What","must","be","shall","be."};
		int length = 0; 
		TextJustification_Failed solu = new TextJustification_Failed();
		List<String> res = solu.fullJustify(words, length);
		for(String s : res)
			System.out.println("["+s+"]");
	}

}
