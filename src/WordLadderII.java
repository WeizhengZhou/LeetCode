import java.util.*;



public class WordLadderII {	
	public class Node{
		String word = null;
		Node pre = null;
		public Node(String word){
			this.word = word;
		}
	}
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	 List<List<String>> res = new ArrayList<List<String>>();
	    if(start == end){
	    	List<String> list = new ArrayList<String>();
	    	list.add(start);
	    	res.add(list);
	    	return res;
	    }
		if(dict == null) 
			return res;
		if(dict.contains(start) && dict.contains(end)){
		    if(start.length() > 1)
		         return res;
		    List<String> list = new ArrayList<>();
		    list.add(start);
		    list.add(end);
		    res.add(list);
	    	return res;
		}
			
			
		boolean foundShortestPath = false;
		
		Set<String> pool = new HashSet<>();	//to store visited strings
		Queue<Node> curLevel = new LinkedList<>();//to store current bfs level
		Queue<Node> nextLevel = new LinkedList<>();//to store next bfs level
			
		Node node = new Node(start);
		pool.add(start);
		curLevel.add(node);
				
		while(!curLevel.isEmpty()){			
			Node curNode = curLevel.remove();
			char[] curCharArray = curNode.word.toCharArray();
			for(int i=0;i<curCharArray.length;i++){
				char original = curCharArray[i];
				for(char c = 'a';c<='z';c++){
					curCharArray[i] = c;
					String nextWord = new String(curCharArray);
										
					Node nextNode = new Node(nextWord);				
					nextNode.pre = curNode;
					
					if(nextWord.equals(end)){
						foundShortestPath = true;
						List<String> list = sequence(nextNode);					
						res.add(list);						
					}								
					//&& !pool.contains(nextNode.word)
					else if(dict.contains(nextWord)){
						pool.add(nextNode.word);
						nextLevel.add(nextNode);
					}
				}
				curCharArray[i] = original;
			}
			if(curLevel.isEmpty()){
				if(foundShortestPath) 
					break;		
				
				curLevel = new LinkedList<>(nextLevel);
				nextLevel.clear();	
			}				
		}	
		return res;       
    }
	
	private List<String> sequence(Node t){
		List<String> list = new LinkedList<String>();
		while(t.pre != null){
			list.add(0,t.word);
			t = t.pre;
		}
		list.add(0, t.word);
		return list;
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
//		String start = "red";
//		String end = "tax";
//		Set<String> dict = new HashSet<String>();
//		dict.add("ted");
//		dict.add("tex");
//		dict.add("red");
//		dict.add("tax");
//		dict.add("tad");
//		dict.add("den");
//		dict.add("rex");
//		dict.add("pee");
		
		String start = "hot";
		String end = "dog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
	
		
		
		
		WordLadderII solution = new WordLadderII();
		
		List<List<String>> lists = solution.findLadders(start, end, dict);
		for(List<String> list : lists){
			for(String s:list){
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
}
