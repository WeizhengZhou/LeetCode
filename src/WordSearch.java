import java.util.*;
public class WordSearch{
	private char[][] board = null;
	int m = 0;
	int n = 0;
	private char[] word = null;
	private boolean[][] visited = null;
		
	public boolean exist(char[][] board, String word_str) {
		if(board == null || word_str == null) return false;	
		this.board = board;
		this.word= word_str.toCharArray();
		this.m = board.length;
		this.n = board[0].length;
		if(m*n < word.length) return false;	
		if(check() == false) return false;
		
		this.visited = new boolean[this.m][this.n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){	
				System.out.println("start at i = " + i + ", j = "+ j);				
			    if(dfs(i, j) == true)
			    	return true;
			}
		}
		return false;
	}
	private boolean dfs(int x, int y){	
		if(board[x][y] != word[0])
			return false;
		Stack<Node> stack = new Stack<>();		
		stack.push(new Node(x,y,0));
		while(!stack.isEmpty()){
			Node c = stack.peek();	
			if(c.k == word.length-1)
				return true;
			if(visited[c.i][c.j] == true){			
				stack.pop();
				visited[c.i][c.j] = false;
			}			
			else{
				visited[c.i][c.j] = true;
				List<Node> adj = adj(c);
				for(Node u : adj){
					if(board[u.i][u.j] == word[u.k] && visited[u.i][u.j] == false){
						stack.push(u);
					}
				}
			}
		}
		return false;		
	}
	private List<Node> adj(Node c){
		int i = c.i;
		int j = c.j;
		int k = c.k;
		
		Node l = new Node(i,        (j-1+n)%n,k+1);
		Node r = new Node(i,        (j+1)%n,  k+1);
		Node u = new Node((i-1+m)%m, j,       k+1);
		Node d = new Node((i+1)%m,   j,       k+1);
		
		List<Node> adj = new LinkedList<>();
		adj.add(l);
		adj.add(r);
		adj.add(u);
		adj.add(d);
		return adj;		
	}
	public class Node{
		int i = 0;
		int j = 0;
		int k = 0;
		public Node(int i, int j, int k){
			this.i = i;
			this.j = j;
			this.k = k;
		}
		public String toString(){
			return "[" + i + "," + j + "," + k + "]";
		}
	}
	private boolean check(){
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(map.containsKey(board[i][j]))
					map.put(board[i][j], map.get(board[i][j]+1));
				else
					map.put(board[i][j], 1);
			}
		}
		for(int i=0;i<word.length;i++){
			char key = word[i];
			if(!map.containsKey(key))
				return false;
			else{
				int value = map.get(key);
				if(value == 1)
					map.remove(key);
				else
					map.put(key, value-1);
			}				
		}
		return true;
	}
	public static void main(String[] args){
//		char[][] board = new char[][]{{'A','B','C','E'},
//			                          {'S','F','C','S'},
//			                          {'A','D','E','E'}};
//		String word = "SEE";
//		word = "ABCESCF";
	    long start = System.currentTimeMillis();
		char[][] board = new char[][]{{'a','a','a','a'},
                                      {'a','a','a','a'},
                                      {'a','a','a','b'}};
		
		String word = "aaaaaaaaaaaa";
//		char[][] board = new char[][]{{'C','A','A'},
//				                      {'A','A','A'},
//				                      {'B','C','D'}};
//		String word = "AAB";
	
		
		WordSearch s = new WordSearch();
		System.out.println(s.exist(board, word));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
}
