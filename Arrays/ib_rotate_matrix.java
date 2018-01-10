public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    transposeMatrix(a);
	    rotateRows(a);
	}

	private void transposeMatrix(ArrayList<ArrayList<Integer>> a) {
	    for (int i = 0; i < a.size(); i++) {
	        for (int j = i; j < a.size(); j++) {
	            swapInMatrix(a, i, j);
	        }
	    }
	}

	private void rotateRows(ArrayList<ArrayList<Integer>> a) {
	    for (int i = 0; i < a.size(); i++) {
	        int k = a.size() - 1;
	        for (int j = 0; j < a.size()/2; j++) {
	            swapInRow(a, i, j, k);
	            k--;
	        }
	    }
	}

	private void swapInMatrix(ArrayList<ArrayList<Integer>> a, int i, int j) {
	    if (i != j) {
	        a.get(i).set(j, a.get(i).get(j) ^ a.get(j).get(i));
	        a.get(j).set(i, a.get(i).get(j) ^ a.get(j).get(i));
	        a.get(i).set(j, a.get(i).get(j) ^ a.get(j).get(i));
	    }
	}

	private void swapInRow(ArrayList<ArrayList<Integer>> a, int i, int j, int k) {
	    a.get(i).set(j, a.get(i).get(j) ^ a.get(i).get(k));
	    a.get(i).set(k, a.get(i).get(j) ^ a.get(i).get(k));
	    a.get(i).set(j, a.get(i).get(j) ^ a.get(i).get(k));
	}
}
