import java.util.*;

public class WordLadder_TLE {
	private List<Node> nodes = new ArrayList<Node>();
	private Node source = null;
	private Node destination = null;
	
	public class Node{
		String name = null;
		int dist = 0;
		List<Node> adj = null;	
		public Node(String name){
			this.name = name;
			dist = -1;
			adj = new LinkedList<>();
		}
		public void  addAdj(Node n){
			adj.add(n);
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("name = " + name + ", dist = " + dist);
			sb.append("\n  adj = ");
			for(Node n : adj){
				sb.append(n.name + ", ");
			}
			return sb.toString();	
		}
	}
	private void buildGraph(String start, String end, Set<String> dict){
		source = new Node(start);
		destination = new Node(end);
		nodes.add(source);
		nodes.add(destination);
		
		for(String s:dict){
			Node node = new Node(s);	
			nodes.add(node);		
		}		
		for(Node a : nodes){
			for(Node b : nodes){
				if(!a.name.equals(b.name) && isConnected(a.name, b.name)){
					a.addAdj(b);
				}
			}
		}		
	}
	private void bfs(Node source){
		Queue<Node> curLevel = new LinkedList<Node>();
		Queue<Node> nextLevel = new LinkedList<Node>();
		source.dist = 0;
		curLevel.add(source);
		while(!curLevel.isEmpty()){
			Node cur = curLevel.remove();
			for(Node neighbor : cur.adj){
				if(neighbor.dist == -1){//not visited before
					neighbor.dist = cur.dist + 1;
					nextLevel.add(neighbor);
				}		
			}
			if(curLevel.isEmpty()){
				curLevel = new LinkedList<>(nextLevel);
				nextLevel.clear();			
			}
		}	
	}
	private boolean isConnected(String a, String b){

		if(a == null || b == null) return false;
		if(a.length() != b.length()) return false;
		int count = 0;
		for(int i=0;i<a.length();i++){
			if(!a.substring(i,i+1).equals(b.substring(i,i+1)))
				count++;
			if(count > 1)
				return false;
		}
//		System.out.println(a + ", " + b);
		return true;
	}
	public int ladderLength(String start, String end, Set<String> dict) {		
		buildGraph(start, end, dict);
		bfs(source);
//		for(Node n : nodes)
//			System.out.println(n);
		return destination.dist + 1;
	}
	public static void main(String[] args){
		String start = "hit";
		String end = "dog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadder_TLE solution = new WordLadder_TLE();
		System.out.println(solution.ladderLength(start, end, dict));
	}
}
