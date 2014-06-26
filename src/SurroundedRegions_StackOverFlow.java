import java.util.*;
public class SurroundedRegions_StackOverFlow {
	private int m = 0;
	private int n = 0;
	private boolean[][] visited = null;
	private char[][] board = null;

	public void solve(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) return;
		this.m = board.length;
		this.n = board[0].length;
		this.visited = new boolean[m][n];
		this.board = board;
	
		for(int j=0;j<n;j++){
			if(board[0][j] == 'O' && visited[0][j] == false)
				bfs(0,j);
			if(board[m-1][j] == 'O' && visited[m-1][j] == false)
				bfs(m-1,j);
		}	
		for(int i=0;i<m;i++){
			if(board[i][0] == 'O' && visited[i][0] == false)
				bfs(i,0);
			if(board[i][n-1] == 'O' && visited[i][n-1] == false)
				bfs(i,n-1);
		}	
		setX();
		print(visited);
		print(board);
    }
	private void bfs(int x, int y){
		Queue<Integer> row = new LinkedList<>();
		Queue<Integer> column = new LinkedList<>();
		row.add(x);
		column.add(y);
		while(!row.isEmpty()){
			int i = row.remove();
			int j = column.remove();
			if(i>=0 && i<m && j>=0 && j<n && board[i][j] == 'O'){
				visited[i][j] = true;
				row.add(i-1);column.add(j);
				row.add(i+1);column.add(j);
				row.add(i);column.add(j-1);
				row.add(i);column.add(j+1);
			}		
		}
		
	}

	private void setX(){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j] == 'O' && visited[i][j] == false)
					board[i][j] = 'X';
			}
		}
	}
	public static void main(String[] args){
//		char[][] board = new char[][]{{'X','X','X','X','',''},
//				                      {'X','O','O','X','',''},
//				                      {'X','X','O','X','',''},
//				                      {'X','O','X','X','',''}};
		char[][] board = new char[][]{{'X','O','X','O','X','O'},
                                      {'O','X','O','X','O','X'},
                                      {'X','O','X','O','X','O'},
                                      {'O','X','O','X','O','X'}};
		SurroundedRegions_StackOverFlow  s = new SurroundedRegions_StackOverFlow ();
		s.solve(board);
		
	}
	private void dfs(int i, int j){
		if(i < 0 || i > m-1 || j < 0 || j > n-1) return;	
		if(board[i][j] == 'O' && visited[i][j] == false){
			visited[i][j] = true;
			dfs(i+1,j);
			dfs(i-1,j);
			dfs(i,j+1);
			dfs(i,j-1);
		}	
	}
	private void print(boolean[][] A){
		for(boolean[] row:A){
			for(boolean b :row){
				System.out.print(b+", ");
			}
			System.out.println();
		}
	}
	private void print(char[][] A){
		for(char[] row:A){
			for(char b :row){
				System.out.print(b+", ");
			}
			System.out.println();
		}
	}

}
