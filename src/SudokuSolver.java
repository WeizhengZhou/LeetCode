import java.util.*;


public class SudokuSolver {
	private char[][] board = null;	
	public void solveSudoku(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9) return;
		this.board = board;
		solve(0,0);		
//		print(this.board);	
    }
	private boolean solve(int i, int j){
		if(i == 9 || j == 9) 
			return true;
		if(board[i][j] != '.') 
			return solve(i+(j+1)/9, (j+1)%9);//next point
		else{					
			for(int k=1;k<=9;k++){
				board[i][j] = Integer.toString(k).charAt(0);//set value			
				//if does not violate current row, column and subblock, solve next position
				if(isRowValid(board,i) && isColumnValid(board,j) 
				   && isSubBlockValid(board, i/3,j/3) && solve(i+(j+1)/9, (j+1)%9)){
					return true;//if next position is correct			
				}					
			}
			//try all possibilities, found no solution, roll back, and return false
			board[i][j] = '.';//remember to roll back
			return false;
		}			
	}
	private boolean isRowValid(char[][] board, int row){  
		BitSet bt = new BitSet(9);
		for(int j=0;j<9;j++){
			if(board[row][j] != '.'){
				int v = board[row][j] - '0';			
				if(bt.get(v-1) == false)
					bt.set(v-1);
				else 
					return false;      			
			}
		}   	
    	return true;
    }
    private boolean isColumnValid(char[][] board, int column){
    	
    	BitSet bt = new BitSet(9);
    	for(int i=0;i<9;i++){
    		if(board[i][column] != '.'){
    			int v = board[i][column] - '0';
    			if(bt.get(v-1) == false)
    				bt.set(v-1);
    			else 
    				return false;	
    		}
    	}	
    	return true;
    	
    } 
    private boolean isSubBlockValid(char[][] board, int x, int y){   	
    	BitSet bt = new BitSet(9);
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			if(board[3*x+i][3*y+j] != '.'){
    				int v = board[3*x+i][3*y+j] - '0';
        			if(bt.get(v-1) == false)
        				bt.set(v-1);
        			else
        				return false;
    			}
    		}
    	}
    	return true;
    }
    public static void main(String[] args){
//    	char[][] board = {{'5','3','.','.','7','.','.','.','.'},
//    			          {'6','.','.','1','9','5','.','.','.'},
//    			          {'.','9','8','.','.','.','.','6','.'},
//    			          {'8','.','.','.','6','.','.','.','3'},
//    			          {'4','.','.','8','.','3','.','.','1'},
//    			          {'7','.','.','.','2','.','.','.','6'},
//    			          {'.','6','.','.','.','.','2','8','.'},
//    			          {'.','.','.','4','1','9','.','.','5'},
//    			          {'.','.','.','.','8','.','.','7','9'}};
    	char[][] board = {{'5','3','.','.','7','.','.','.','.'},
    			          {'6','.','.','1','9','5','.','.','.'},
    			          {'.','9','8','.','.','.','.','6','.'},
		                  {'8','.','.','.','6','.','.','.','3'},
		                  {'4','.','.','8','.','3','.','.','1'},
		                  {'7','.','.','.','2','.','.','.','6'},
		                  {'.','6','.','.','.','.','2','8','.'},
		                  {'.','.','.','4','1','9','.','.','5'},
		                  {'.','.','.','.','8','.','.','7','9'}};
//    	System.out.println(Character.getNumericValue(boad[0][1])); 
    	SudokuSolver solution = new SudokuSolver();
    	solution.solveSudoku(board);;
    	
    }
    private void print(char[][] board){
    	for(char[] row : board){
    		for(char c : row){
    			System.out.print(c + ", ");
    		}
    		System.out.println();
    	}
    }
}
