public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {

	    if (a == null || a.size() < 2) {
	        return new ArrayList<Integer>();
	    }

	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	    int i = 0;

	    while (i < a.size() && !map.containsKey(a.get(i))) {

	        if (!map.containsKey(b - a.get(i))) {
	            map.put(b - a.get(i), i+1);
	        }
	        i++;

	    }

	    if (i == a.size()) {
	        return new ArrayList<Integer>();
	    }

	    ArrayList<Integer> res = new ArrayList<Integer>();
	    res.add(map.get(a.get(i)));
	    res.add(i+1);
	    return res;
	}
}
