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
			
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){	
//				System.out.println("start at i = " + i + ", j = "+ j);
				this.visited = new boolean[this.m][this.n];
			    if(dfs(i, j) == true)
				   return true;
			}
		}
		return false;
	}
	private boolean dfs(int x, int y){
		Stack<Integer> row = new Stack<>();
		Stack<Integer> column = new Stack<>();
		Stack<Integer> kstack = new Stack<>();
		row.push(x);
		column.push(y);
		kstack.push(0);
		while(!row.isEmpty() && kstack.peek() < word.length){
			int i = row.pop();
			int j = column.pop();
			int k = kstack.pop();
			
			if(visited[i][j] == false && word[k] == board[i][j]){
				if(k == word.length -1)
					return true;
				
				visited[i][j] = true;
				row.push((i-1+m)%m); column.push(j); kstack.push(k+1);
				row.push((i+1)%m);   column.push(j); kstack.push(k+1);
				row.push(i);         column.push((j-1+n)%n); kstack.push(k+1);
				row.push(i);         column.push((j+1)%n); kstack.push(k+1);
			}
		}
		return false;		
	}
	
	public static void main(String[] args){
//		char[][] board = new char[][]{{'A','B','C','E'},
//			                          {'S','F','C','S'},
//			                          {'A','D','E','E'}};
//		String word = "SEE";
//		word = "ABCESCF";
//		char[][] board = new char[][]{{'b','a','a','a'},
//                                      {'a','a','a','a'},
//                                      {'a','a','a','b'}};
		
//		String word = "babaaaaaaaaa";
		char[][] board = new char[][]{{'C','A','A'},
				                      {'A','A','A'},
				                      {'B','C','D'}};
		String word = "AAB";
	
		
		WordSearch s = new WordSearch();
		System.out.println(s.exist(board, word));
		
	}
}
