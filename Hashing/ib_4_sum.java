public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {

	    if (a == null) {
	        return null;
	    }

	    if (a.size() < 4) {
	        return new ArrayList<ArrayList<Integer>>();
	    }

	    int[] arr = new int[a.size()];
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = a.get(i);
	    }

	    Arrays.sort(arr);

	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    for (int i = 0; i < arr.length-3; i++) {

	        if (i != 0 && arr[i] == arr[i-1]) {
	            continue;
	        }

	        for (int j = i+1; j < arr.length-2; j++) {

	            if (j != i+1 && arr[j] == arr[j-1]) {
	                continue;
	            }

	            int k = j+1;
	            int l = arr.length-1;

	            while (k < l) {
	                if (arr[i] + arr[j] + arr[k] + arr[l] < b) {
	                    k++;
	                } else if (arr[i] + arr[j] + arr[k] + arr[l] > b) {
	                    l--;
	                } else {
	                    ArrayList<Integer> q = new ArrayList<Integer>();
	                    q.add(arr[i]);
	                    q.add(arr[j]);
	                    q.add(arr[k]);
	                    q.add(arr[l]);

	                    result.add(q);

	                    k++;
	                    l--;

	                    while (k < l && arr[l] == arr[l+1]) {
	                        l--;
	                    }

	                    while (k < l && arr[k] == arr[k-1]) {
	                        k++;
	                    }
	                }
	            }
	        }
	    }

	    return result;
	}
}
