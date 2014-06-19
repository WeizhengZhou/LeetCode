
import java.util.*;
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
    	if(board == null) return false;
    	if(board.length != 9 || board[0].length != 9) return false;
    	return isRowValid(board) && isColumnValid(board) && isBlockValid(board);      
    }
    private boolean isRowValid(char[][] board){
    	for(int i=0;i<9;i++){
    		BitSet bt = new BitSet(9);
        	for(int j=0;j<9;j++){
        		if(board[i][j] != '.'){
            		int v = board[i][j] - '0';
            		if(bt.get(v) == false)
            			bt.set(v);
            		else 
            			return false;      			
        		}
        	}
    	}
    	return true;
    }
    private boolean isColumnValid(char[][] board){
    	for(int j=0;j<9;j++){
    		BitSet bt = new BitSet(9);
        	for(int i=0;i<9;i++){
        		if(board[i][j] != '.'){
        			int v = board[i][j] - '0';
            		if(bt.get(v) == false)
            			bt.set(v);
            		else 
            			return false;	
        		}
        	}
    	}
    	return true;
    	
    }
    private boolean isBlockValid(char[][] board){
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			if(! isSubBlockValid(board, 3*i, 3*j))
    				return false;
    		}
    	}
    	return true;
    }
    private boolean isSubBlockValid(char[][] board, int m, int n){
    	BitSet bt = new BitSet(9);
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			if(board[m+i][n+j] != '.'){
    				int v = board[m+i][n+j] - '0';
        			if(bt.get(v) == false)
        				bt.set(v);
        			else
        				return false;
    			}
    		}
    	}
    	return true;
    }
    public static void main(String[] args){
    	char[][] board = {{'.','8','7','6','5','4','3','2','1'},
    			          {'2','.','.','.','.','.','.','.','.'},
    			          {'3','.','.','.','.','.','.','.','.'},
    			          {'4','.','.','.','.','.','.','.','.'},
    			          {'5','.','.','.','.','.','.','.','.'},
    			          {'6','.','.','.','.','.','.','.','.'},
    			          {'7','.','.','.','.','.','.','.','.'},
    			          {'8','.','.','.','.','.','.','.','.'},
    			          {'9','.','.','.','.','.','.','.','.'}};
//    	System.out.println(Character.getNumericValue(board[0][1])); 
    	ValidSudoku solution = new ValidSudoku();
    	System.out.println(solution.isValidSudoku(board));
    }

}
