
public class WordSearch_Test {
	private char[][] board = null;
	int m = 0;
	int n = 0;
	private char[] word = null;
	private boolean[][] visited = null;
	
	public boolean exist(char[][] board, String wordStr) {
		if(board == null || wordStr == null) return false;		
		this.board = board;
		this.word= wordStr.toCharArray();		
		this.m = board.length;
		this.n = board[0].length;
		this.visited = new boolean[m][n];
		
		if(m*n < word.length) return false;//quick check
			
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){	
			   if(dfs(0, i, j) == true)//dfs from i and j
				   return true;
			}
		}
		return false;
	}
	public boolean dfs(int k, int x, int y){
		if(k == word.length) return true;//found a path	
		if(x < 0 || x >=m || y < 0 || y>= n) return false;//exceed boundary	
		if(visited[x][y] == true || word[k] != board[x][y])//visited before or not match
			return false;
		
		visited[x][y] = true;//set [x,y] visited
		boolean res = false;
		//dfs left, right, up and bottom
		res = dfs(k+1,x-1,y) || dfs(k+1,x+1,y) || dfs(k+1,x,y-1)|| dfs(k+1,x,y+1);
		visited[x][y] = false;//restore visited
		return res;		
	}
	public static void main(String[] args){
//		char[][] board = new char[][]{{'a','a','a','a'},
//                                      {'a','a','a','a'},
//                                      {'a','a','a','b'}};		
//		String word = "aaaaaaaaaaab";
		char[][] board = new char[][]{{'a'}};
		String word = "a";
		WordSearch_Test s = new WordSearch_Test();
		System.out.println(s.exist(board, word));
		
	}

}
