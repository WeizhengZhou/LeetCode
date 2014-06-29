import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * This solution time exceed limit, 
 * maybe because of I used a list<list<String>> for each word to record its path to start
 * therefore, a lot of lists were created and copied. So, it used  a lot more time. 
 * @author Weizheng
 *
 */
public class WordLadderII_TEL {	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	Map<String, List<List<String>>> map = new HashMap<>();//map string to sequence from start to this string
    	
    	List<List<String>> lists = new LinkedList<List<String>>();
    	List<String> list = new LinkedList<>();
    	list.add(start);
    	lists.add(list);
    	map.put(start,lists);
    	
    	int nLevel = 1;
    	Queue<String> curLevel = new LinkedList<>();
    	Queue<String> nextLevel = new LinkedList<>();
    	curLevel.add(start);
    	
    	while(!curLevel.isEmpty()){
    		String curStr = curLevel.remove();   		
    		char[] curChar = curStr.toCharArray();  
//    		System.out.println("cur word = " + curStr);
//    		System.out.println("map = " + map);
    		List<List<String>> curLists = map.get(curStr);
    		for(int i=0;i<curChar.length;i++){//for each digit in curChar
    			char original = curChar[i];
    			for(char t='a';t<='z';t++){//for each possible next word				
    				curChar[i] = t;
    				String nextStr = new String(curChar); 
    				//if identical to curChar, or dict does not have this word
    				if(t == original || (!dict.contains(nextStr) && !nextStr.equals(end))) continue;
    						
    				List<List<String>> nextLists = null;//next word's lists
    				if(map.containsKey(nextStr)){//already discovered this word
    					nextLists = map.get(nextStr);
    					List<String> temp = nextLists.get(0);
    					if(temp.size() < nLevel+1)//if this result has a larger distance to start, skip this result
    						continue; 	
    					nextLevel.add(nextStr);//add to nextLevel	
    				}
    				else{//discover a new word
    					nextLevel.add(nextStr);//add to nextLevel
    					nextLists = new LinkedList<List<String>>();
    				}
    				  				
    				for(List<String> curList:curLists){
    					List<String> nextList = new LinkedList<>(curList);//copy sequence from start to curStr
    					nextList.add(nextStr);//add nextStr to sequence
    					nextLists.add(nextList);
    				}
    				map.put(nextStr, nextLists);
    			}
    			curChar[i] = original;
    		}
    		if(curLevel.isEmpty()){
    			if(map.containsKey(end)){
    				//found end word
//    				System.out.println("OK");
    				return map.get(end);
    			} 				
    			else{
    				nLevel++;
    				curLevel = new LinkedList<>(nextLevel);
    				nextLevel.clear();
    			}				
    		}			
    	}
    	if(map.containsKey(end))
    		return map.get(end);
    	else
    		return new LinkedList<List<String>>();
    	 
    }
	
	public static void main(String[] args){
//		String start = "hit";
//		String end = "cog";
//		Set<String> dict = new HashSet<String>();
//		dict.add("hot");
//		dict.add("dot");
//		dict.add("dog");
//		dict.add("lot");
//		dict.add("log");
//		
		String start = "red";
		String end = "tax";
		Set<String> dict = new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("tax");
		dict.add("tad");
		dict.add("den");
		dict.add("rex");
		dict.add("pee");
		
//		String start = "hot";
//		String end = "dog";
//		Set<String> dict = new HashSet<String>();
//		dict.add("hot");
//		dict.add("dog");
		
		
		WordLadderII_TEL solution = new WordLadderII_TEL();
		
		List<List<String>> lists = solution.findLadders(start, end, dict);
		for(List<String> list : lists){
			for(String s:list){
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
}
