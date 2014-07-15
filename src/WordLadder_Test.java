import java.util.*;


public class WordLadder_Test {
	public int ladderLength(String start, String end, Set<String> dict) {
		if(start == null || end == null || dict == null || dict.size() == 0) return 0;
		Map<String, Integer> visited = new HashMap<>();
		Queue<String> curLevel = new LinkedList<>();
		Queue<String> nextLevel = new LinkedList<>();
		
		visited.put(start, 1);
		curLevel.add(start);
		while(!curLevel.isEmpty()){
			
			String curStr = curLevel.remove();
			int curDist = visited.get(curStr);
			char[] curArr = curStr.toCharArray();
			for(int i=0;i<curArr.length;i++){
				char original = curArr[i];
				for(char c='a';c<='z';c++){
					curArr[i] = c;
					String nextStr = new String(curArr);
					if(nextStr.equals(end))
						return curDist+1;
					if(dict.contains(nextStr) && !visited.containsKey(nextStr)){
						visited.put(nextStr, curDist+1);
						nextLevel.add(nextStr);
					}
				}
				curArr[i] = original;
			}		
			if(curLevel.isEmpty()){
			
				curLevel = new LinkedList<>(nextLevel);
				nextLevel.clear();
			}			
		}
		return 0;
	}
	public static void main(String[] args){
		String start = "hot";
		String end = "dog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
//		dict.add("dot");
		dict.add("dog");
//		dict.add("lot");
//		dict.add("log");
		WordLadder_Test solution = new WordLadder_Test();
		
		System.out.println(solution.ladderLength(start, end, dict));
	}

}
