import java.util.*;
public class WordLadderII_Test {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	
		if(start == null || end == null || dict == null || dict.size() == 0)
			return new LinkedList<List<String>>();
		
		dict.add(end);//add end word to dict
		
		Map<String, List<List<String>>> map = new HashMap<>();//<key, path from start to key>
		
		List<List<String>> lists = new LinkedList<List<String>>();
		List<String> list = new LinkedList<>();
		list.add(start);
		lists.add(list);
		map.put(start,lists);//<start, path to start>
		
		Queue<String> curLevel = new LinkedList<>();//bfs's current level
		Queue<String> nextLevel = new LinkedList<>();//bfs's next level
		curLevel.add(start);//add start to current level
		
		while(!curLevel.isEmpty()){
			String curStr = curLevel.remove();//current string
			List<List<String>> curLists = map.get(curStr);//path to curStr
				
			char[] curArr = curStr.toCharArray();
			for(int i=0;i<curArr.length;i++){//for each index in array
				char original = curArr[i];//store original character
				for(char c='a';c<='z';c++){//for each transformation
					if(c == original) continue;//avoid self loop
					curArr[i] = c;//change character
					String nextStr = new String(curArr);//next string
					if(dict.contains(nextStr)){//dict contains next string
						List<List<String>> nextLists = null;//path to next string
						if(!map.containsKey(nextStr)){//new path found
							nextLevel.add(nextStr);
							nextLists = new LinkedList<List<String>>();							
						}
						else{//visited nextStr before
							nextLists = map.get(nextStr);
						}
						for(List<String> curList:curLists){//build path to nextStr
							List<String> nextList = new LinkedList<>(curList);
							nextList.add(nextStr);
							nextLists.add(nextList);						
						}
						map.put(nextStr, nextLists);//put nextStr and its path to map
					}
				}
				curArr[i] = original;//restore char array
			}	
			if(curLevel.isEmpty()){//current level is done
				if(map.containsKey(end)){//check if visited end word
					return map.get(end);
				}
				curLevel = new LinkedList<String>(nextLevel);//move to next level
				nextLevel.clear();
			}
		}
		return null;
	
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

				
		WordLadderII_Test solution = new WordLadderII_Test();
		
		List<List<String>> lists = solution.findLadders(start, end, dict);
		for(List<String> list : lists){
			for(String s:list){
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}

}
