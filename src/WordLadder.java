import java.util.*;


public class WordLadder {	
	public class Node{
		String word = null;
		Node pre = null;
		public Node(String word){
			this.word = word;
		}
	}
	public int ladderLength(String start, String end, Set<String> dict) {		
		if(start == end) return 1;
		if(dict == null) return 0;
		
		int distance = 1;
		
		Set<String> pool = new HashSet<>();	//to store visited strings
		Queue<Node> curLevel = new LinkedList<>();//to store current bfs level
		Queue<Node> nextLevel = new LinkedList<>();//to store next bfs level
		
		Node destination = null;
		
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
						print(nextNode);
						return distance + 1;	
					}									
					else if(dict.contains(nextWord) && !pool.contains(nextNode.word)){
						pool.add(nextNode.word);
						nextLevel.add(nextNode);
					}
				}
				curCharArray[i] = original;
			}
			if(curLevel.isEmpty()){
				curLevel = new LinkedList<>(nextLevel);
				nextLevel.clear();
				distance++;	
			}				
		}	
		return 0;
	}
	private void print(Node t){
		if(t.pre == null)
			System.out.print(t.word);
		else{
			print(t.pre);
			
			System.out.print(" -> " + t.word);
		}
	}
	
	public static void main(String[] args){
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadder solution = new WordLadder();
		
		System.out.println(solution.ladderLength(start, end, dict));
	}
}
