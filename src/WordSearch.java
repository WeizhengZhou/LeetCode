import java.util.*;
public class WordSearch {
	private char[][] board = null;
	int m = 0;
	int n = 0;
	int p = 0;
	private char[] word = null;
	private int[][][] visited = null;
	
	public boolean exist(char[][] board, String word_str) {
		if(board == null || word_str == null) return false;
		
		this.board = board;
		this.word= word_str.toCharArray();
		
		this.m = board.length;
		this.n = board[0].length;
		this.p = word.length;
		this.visited = new int[this.m][this.n][this.p];
		
		if(m*n < p) return false;
			
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){		
			   if(dfs(i, j, 0) == 1)
				   return true;
			}
		}
		return false;
	}
	public int dfs(int x, int y, int k){
//		System.out.println("k = " + k + ", x = " + x + ", y = " + y);
		if(k == word.length)
			return 1;
		if(visited[x][y][k] != 0)
			return visited[x][y][k];
			
		if(word[k] != board[x][y])
			
	
	    int l,r,u,d;
		
		l = dfs(k+1, (x-1+m)%m,    y);//left neighbor
		r = dfs(k+1, (x+1)%m,      y);//right neighbor
		u = dfs(k+1, x,        (y-1+n)%n);//upper neighbor
		d = dfs(k+1, x,        (y+1)%n);//down neighbor
		
				
	}
	public static void main(String[] args){
//		char[][] board = new char[][]{{'A','B','C','E'},
//			                          {'S','F','C','S'},
//			                          {'A','D','E','E'}};
		char[][] board = new char[][]{{'b','a','a','a'},
                                      {'a','a','a','a'},
                                      {'a','a','a','b'}};
		
		String word = "babaaaaaaaaa";
		WordSearch s = new WordSearch();
		System.out.println(s.exist(board, word));
		
	}
}
