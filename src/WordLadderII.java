import java.util.*;

public class WordLadderII {	
	public class Node{
		String s = null;
		int d = 0;
		List<Node> pre = null;
		public Node(String s, int d){
			this.s = s;
			this.d = d;
		}
		public String toString(){
			return s + ", " + d;
		}
	}
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	Map<String, Node> map = new HashMap<>();//map string to sequence from start to this string
    	
    	Node node = new Node(start,1);
    	map.put(start,node);
    		
    	Queue<Node> curLevel = new LinkedList<>();
    	Queue<Node> nextLevel = new LinkedList<>();
    	curLevel.add(node);
    	
    	int nLevel = 2;
    	while(!curLevel.isEmpty()){
    		Node cur = curLevel.remove();   		
    		char[] curChar = cur.s.toCharArray();  
    		System.out.println("cur word = " + Arrays.toString(curChar));
    		System.out.println("map = " + map);
    		
    		for(int i=0;i<curChar.length;i++){//for each digit in curChar
    			char original = curChar[i];
    			for(char t='a';t<='z';t++){//for each possible next word				
    				curChar[i] = t;
    				String nextStr = new String(curChar); 
 
    				if(t == original) continue;
    			
    				if((!dict.contains(nextStr) && !nextStr.equals(end))) continue;
    				
    				if(map.containsKey(nextStr)){//already discovered this word
    					if(map.get(nextStr).d == nLevel)
    					     map.get(nextStr).pre.add(cur);			
    				}
    				else{//discover a new word, or this sequence is also a shortest sequence
    					Node next = new Node(nextStr,nLevel);
    					next.pre = new LinkedList<>();
    					next.pre.add(cur);
    					map.put(nextStr, next);
    					nextLevel.add(next);//add to nextLevel 					
    				}
    			}
    			curChar[i] = original;
    		}
    		if(curLevel.isEmpty()){
    			if(map.containsKey(end)){
    				break;		
    			} 				
    			else{
    				nLevel++;
    				curLevel = new LinkedList<>(nextLevel);
    				nextLevel.clear();
    			}				
    		}			
    	}  
    	if(map.containsKey(end))
    		return sequence(map.get(end));
    	else
    		return new LinkedList<List<String>>();
    }
    private List<List<String>> sequence(Node n){
    	if(n.pre == null){ 		
    		List<String> list = new LinkedList<>();
    		list.add(n.s);
    		List<List<String>> lists = new LinkedList<List<String>>();
    		lists.add(list);
    		return lists;
    	}  		
    	else{
    		List<List<String>> res = new LinkedList<List<String>>();
            for(Node u : n.pre){
            	List<List<String>> lists = sequence(u);
            	for(List<String> list:lists){
            		list.add(n.s);
            		res.add(list);
            	}
            }
            return res;
    	}
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
