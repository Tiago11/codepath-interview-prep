public class Solution {
	public int isValidSudoku(final List<String> a) {

	    int[][] board = new int[9][9];
	    for (int i = 0; i < a.size(); i++) {
	        for (int j = 0; j < a.get(i).length(); j++) {
	            if (a.get(i).charAt(j) == '.') {
	                board[i][j] = 0;
	            } else {
	                board[i][j] = Character.getNumericValue(a.get(i).charAt(j));
	            }
	        }
	    }

	    boolean isValid = true;

	    for (int i = 0; i < board.length; i++) {
	        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	        for (int j = 0; j < board.length; j++) {
	            if (board[i][j] > 0) {
	                if (map.containsKey(board[i][j])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i][j], true);
	                }
	            }
	        }
	    }

	    if (!isValid) {
	        return 0;
	    }

	    for (int j = 0; j < board.length; j++) {
	        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	        for (int i = 0; i < board.length; i++) {
	            if (board[i][j] > 0) {
	                if (map.containsKey(board[i][j])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i][j], true);
	                }
	            }
	        }
	    }

	    if (!isValid) {
	        return 0;
	    }

	    for (int i = 0; i < board.length-3; i+=3) {
	        for (int j = 0; j < board.length-3; j+=3) {
	            Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	            if (board[i][j] > 0) {
	                if (map.containsKey(board[i][j])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i][j], true);
	                }
	            }
	            if (board[i][j+1] > 0) {
	                if (map.containsKey(board[i][j+1])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i][j+1], true);
	                }
	            }
	            if (board[i][j+2] > 0) {
	                if (map.containsKey(board[i][j+2])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i][j+2], true);
	                }
	            }
	            if (board[i+1][j] > 0) {
	                if (map.containsKey(board[i+1][j])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i+1][j], true);
	                }
	            }
	            if (board[i+1][j+1] > 0) {
	                if (map.containsKey(board[i+1][j+1])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i+1][j+1], true);
	                }
	            }
	            if (board[i+1][j+2] > 0) {
	                if (map.containsKey(board[i+1][j+2])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i+1][j+2], true);
	                }
	            }
	            if (board[i+2][j] > 0) {
	                if (map.containsKey(board[i+2][j])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i+2][j], true);
	                }
	            }
	            if (board[i+2][j+1] > 0) {
	                if (map.containsKey(board[i+2][j+1])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i+2][j+1], true);
	                }
	            }
	            if (board[i+2][j+2] > 0) {
	                if (map.containsKey(board[i+2][j+2])) {
	                    isValid = false;
	                    break;
	                } else {
	                    map.put(board[i+2][j+2], true);
	                }
	            }
	        }
	    }

	    if (!isValid) {
	        return 0;
	    } else {
	        return 1;
	    }
	}
}
