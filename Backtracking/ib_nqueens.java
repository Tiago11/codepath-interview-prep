public class Solution {
	public ArrayList<ArrayList<String>> solveNQueens(int a) {

	    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	    int[][] board = new int[a][a];

	    solveNQueensBT(board, 0, res);

	    return res;
	}

	private void solveNQueensBT(int[][] board, int col, ArrayList<ArrayList<String>> res) {
	    if (col == board.length) {
	        transformBoard(board, res);
	        return;
	    }

	    for (int i = 0; i < board.length; i++) {
	        if (isSafe(board, i, col)) {
	            board[i][col] = 1;
	            solveNQueensBT(board, col+1, res);
	            board[i][col] = 0;
	        }
	    }
	}

	private boolean isSafe(int[][] board, int row, int col) {
	    int i = 0;
	    int j = 0;

	    while (j < col) {
	        if (board[row][j] == 1) {
	            return false;
	        }
	        j++;
	    }

	    i = row;
	    j = col;

	    while (i >= 0 && j >= 0) {
	        if (board[i][j] == 1) {
	            return false;
	        }

	        i--;
	        j--;
	    }

	    i = row;
	    j = col;

	    while (i < board.length && j >= 0) {
	        if (board[i][j] == 1) {
	            return false;
	        }

	        i++;
	        j--;
	    }

	    return true;
	}

	private void transformBoard(int[][] board, ArrayList<ArrayList<String>> res) {
	    ArrayList<String> trBoard = new ArrayList<String>();
	    for (int i = 0; i < board.length; i++) {
	        StringBuilder sb = new StringBuilder("");
	        for (int j = 0; j < board.length; j++) {
	            if (board[i][j] == 0) {
	                sb.append(".");
	            } else {
	                sb.append("Q");
	            }
	        }
	        trBoard.add(sb.toString());
	    }
	    res.add(trBoard);
	}
}
