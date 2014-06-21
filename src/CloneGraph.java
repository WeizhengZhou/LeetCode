import java.util.*;
public class CloneGraph {
	public class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("node  " + this.label + ": ");
			for(UndirectedGraphNode node : neighbors)
				sb.append(" -> " + node.label );
			return  sb.toString();
		}
	};
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		
		UndirectedGraphNode node_cp = new UndirectedGraphNode(node.label);	
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
			
		Map<Integer,UndirectedGraphNode> visited = new HashMap<>();		
		queue.add(node);
		visited.put(node.label, node_cp);
				
		while(!queue.isEmpty()){
			UndirectedGraphNode u = queue.remove();
			UndirectedGraphNode u_cp = visited.get(u.label);							
			for(UndirectedGraphNode v : u.neighbors){	
				if(!visited.containsKey(v.label)){//this edge not visited before
					queue.add(v);
					UndirectedGraphNode v_cp = new UndirectedGraphNode(v.label);	
					u_cp.neighbors.add(v_cp);
					visited.put(v.label, v_cp);									
				}
				else{
					UndirectedGraphNode v_cp = visited.get(v.label);
					u_cp.neighbors.add(v_cp);
				}
			}
//			System.out.println(u_cp);
//			System.out.println("queue = " + queue);
			
		}
		return node_cp;
	}
	public static void main(String[] args){
		CloneGraph graph = new CloneGraph();
		CloneGraph.UndirectedGraphNode node_1 = graph.new UndirectedGraphNode(1);
		CloneGraph.UndirectedGraphNode node_2 = graph.new UndirectedGraphNode(2);
		CloneGraph.UndirectedGraphNode node_3 = graph.new UndirectedGraphNode(3);
		node_1.neighbors.add(node_2);
		node_1.neighbors.add(node_3);
		node_2.neighbors.add(node_1);
		node_3.neighbors.add(node_1);
	
		graph.cloneGraph(node_1);			
	}

}
