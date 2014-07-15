import java.util.*;

public class WordLadderII {	
	public class Node{
		String s = null;
		int dist = 0;
		List<Node> pre = null;
		public Node(String s){
			this.s = s;	
			this.dist = 0;
			this.pre = new LinkedList<>();			
		}
		public String toString(){
			return "[s = " + this.s + ", pre = " + pre + "]";
		}
	}
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	if(start == null || end == null || dict == null || dict.size() == 0) 
    		return new LinkedList<List<String>>();
    	
    	dict.add(end);
   
    	Map<String, Node> map = new HashMap<>();
    	Node startNode = new Node(start);
    	map.put(start,startNode);
    		
    	Queue<String> curLevel = new LinkedList<>();
    	Queue<String> nextLevel = new LinkedList<>();
    	curLevel.add(start);
    	
    	int level = 2;

    	while(!curLevel.isEmpty()){
    		String curStr = curLevel.remove();  
    		Node curNode = map.get(curStr);
    		char[] curChar = curStr.toCharArray();  
    		for(int i=0;i<curChar.length;i++){
    			char original = curChar[i];
    			for(char c='a';c<='z';c++){	
    				if(c == original) continue;//not itself
    				curChar[i] = c;//change letter  				
    				String nextStr = new String(curChar);  
    				if((!dict.contains(nextStr)))//nextStr not in dict  
    					continue; 
    				
    				Node nextNode = null;
    				if(!map.containsKey(nextStr)){//first visite nextStr
    					nextNode = new Node(nextStr);//create nextNode
    					nextNode.dist = level;//assign distance to start word   					    					
    					nextLevel.add(nextStr);//add to next level
    					map.put(nextStr, nextNode);//put it into map
    				}   					
    				else{
    					nextNode = map.get(nextStr);
    					if(level > nextNode.dist)//if visited, and not in cur Level, this visit is not shortest
    						continue;
    				}
    				nextNode.pre.add(curNode);//update nextNode's previous node as curNode
    			}
    			curChar[i] = original;//restore to original letter
    		}
    		if(curLevel.isEmpty()){//done with current level
    			if(map.containsKey(end))//visited end word
    				return sequence(map.get(end));//return list of sequences 				
    			curLevel = new LinkedList<>(nextLevel);//copy nextLevel to curLevel
    			nextLevel.clear();//clear nextLevel
    			level++;//level number++
    		}			
    	}  
    	 return new LinkedList<List<String>>();
    }
    private List<List<String>> sequence(Node n){
    	if(n.pre.size() == 0){//n = start word 	
    		List<List<String>> lists = new LinkedList<List<String>>();
    		List<String> list = new LinkedList<>();
    		list.add(n.s); 	
    		lists.add(list);
    		return lists;
    	}  		
    	else{
    		List<List<String>> res = new LinkedList<List<String>>();
            for(Node p : n.pre){//for each n' previous word
            	List<List<String>> lists = sequence(p);//generate previous node's sequences
            	for(List<String> list:lists){//for each sequence to reach previous node
            		list.add(n.s);//add this node
            		res.add(list);//add sequence to res
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
