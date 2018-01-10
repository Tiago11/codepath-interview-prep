public class Solution {
	public void nextPermutation(ArrayList<Integer> a) {

	    int i = a.size()-2;

	    while (i >= 0 && a.get(i) > a.get(i+1)) {
	        i--;
	    }

	    if (i >= 0) {
    	    int p = a.get(i);

    	    int j = a.size()-1;
    	    while (j >=0 && a.get(j) < p) {
    	        j--;
    	    }

    	    int q = a.get(j);

    	    swap(a, i, j);
	    }
	    reverse(a, i+1, a.size()-1);
	}

	private void swap(ArrayList<Integer> a, int i, int j) {
	    int tmp = a.get(i);
	    a.set(i, a.get(j));
	    a.set(j, tmp);
	}

	private void reverse(ArrayList<Integer> a, int left, int right) {
	    while (left < right) {
	        swap(a, left, right);
	        left++;
	        right--;
	    }
	}
}
