import java.util.*;
public class NQueues {
    public List<String[]> solveNQueens(int n) {
    	boolean[][] board = new boolean[n][n];    	
    	List<String[]> list = new ArrayList<String[]>();
    	nQueues_helper(board,0,n,list);
    	print(list);
    	return list;      
    }
    public void nQueues_helper(boolean[][] board, int row, int n, List<String[]> list){
    	if(row == n){
    		String[] s = new String[n];
    		for(int i=0;i<n;i++){
    			StringBuilder sb = new StringBuilder();
    			for(int j=0;j<n;j++){
    				if(board[i][j] == true)
    					sb.append("Q");
    				else
    					sb.append(".");
    			}
    			s[i] = sb.toString();
    		}
    		list.add(s);
    		return;
    	}
    	
    	for(int j=0;j<n;j++){
    		if(isValid(board,row,j)){  			
    	    	board[row][j] = true;
    			nQueues_helper(board,row+1,n,list);
    			board[row][j] = false;
    		}  		
    	}    	
    }
    public boolean isValid(boolean[][] board, int i, int j){    	
    	for(int k =0;k<board.length;k++){
    		if(board[i][k] == true || board[k][j] == true)
    			return false;
    	}  	
    	int m = i; int n = j;
    	while(m < board.length && n < board.length){
    		if(board[m++][n++] == true)
    			return false;  	
    	}
    	m = i;n = j;
    	while(m < board.length && n >= 0){
    		if(board[m++][n--] == true)
    			return false;
    	}
    	m = i;n = j;
    	while(m >= 0 && n < board.length){
    		if(board[m--][n++] == true)
    			return false;
    	}
    	m = i;n = j;
    	while(m >= 0 && n >= 0){
    		if(board[m--][n--] == true)
    			return false;
    	}
    	return true;  	
    }
    public static void main(String[] args){
//    	boolean[][] board = new boolean[][]{{false,false,false,false},
//    			                            {false,false,false,false},
//    	                                    {false,false,false,false},
//    	                                    {false,false,false,false}};
    	List<String[]> list = new ArrayList<String[]>();
    	NQueues solution = new NQueues();
//    	solution.updateBoard(board, 2, 2);
//    	solution.print(board);
    	solution.solveNQueens(4);
    	
    }
    private void print(boolean[][] board){
    	for(boolean[] row : board){
    		for(boolean b : row){
    			System.out.print(b + ", ");
    		}
    		System.out.println();
    	}
    }
    private void print(List<String[]> list){
    	for(String[] s:list){
    		for(int i=0;i<s.length;i++){
    			System.out.println(s[i]);
    		}
    		System.out.println("-------");
    	}
    }

}
