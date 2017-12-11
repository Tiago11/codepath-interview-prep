public class Solution {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

	    int i = 0;

	    while (i < a.size() && a.get(i).get(0) < b) {
	        i++;
	    }

	    if (i != a.size() && a.get(i).get(0) == b) {
	        return 1;
	    }

	    if (i == 0) {
	        return 0;
	    }

	    i--;
	    if (a.get(i).get(a.get(i).size()-1) < b) {
	        return 0;
	    }

	    int j = 0;
	    while (a.get(i).get(j) < b) {
	        j++;
	    }

	    if (a.get(i).get(j) == b) {
	        return 1;
	    } else {
	        return 0;
	    }
	}
}
