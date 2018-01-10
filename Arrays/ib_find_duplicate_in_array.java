public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {

	    Set<Integer> set = new HashSet<Integer>();
	    int res = -1;

	    for (int i = 0; i < a.size(); i++) {
	        if (set.contains(a.get(i))) {
	            res = a.get(i);
	            break;
	        } else {
	            set.add(a.get(i));
	        }
	    }

	    return res;
	}
}
