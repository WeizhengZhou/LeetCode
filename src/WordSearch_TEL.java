public class WordSearch_TEL {
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
		this.visited = new boolean[this.m][this.n];
		
		if(m*n < word.length) return false;
			
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){	
//				System.out.println("start at i = " + i + ", j = "+ j);
			   if(dfs(0, i, j) == true)
				   return true;
			}
		}
		return false;
	}
	public boolean dfs(int k, int x, int y){
//		System.out.println("k = " + k + ", x = " + x + ", y = " + y);
		if(k == word.length)
			return true;
		
		if(visited[x][y] == true || word[k] != board[x][y])
			return false;
		
		visited[x][y] = true;
		boolean res = false;
		res = dfs(k+1, (x-1+m)%m, y) || dfs(k+1, (x+1)%m,y) 
				|| dfs(k+1, x, (y-1+n)%n)|| dfs(k+1, x, (y+1)%n);
		visited[x][y] = false;
		return res;
			
	}
	public static void main(String[] args){
//		char[][] board = new char[][]{{'A','B','C','E'},
//			                          {'S','F','C','S'},
//			                          {'A','D','E','E'}};
		char[][] board = new char[][]{{'a','a','a','a'},
                                      {'a','a','a','a'},
                                      {'a','a','a','b'}};
		
		String word = "baaaaaaaaaaa";
		WordSearch_TEL s = new WordSearch_TEL();
		System.out.println(s.exist(board, word));
		
	}
}
