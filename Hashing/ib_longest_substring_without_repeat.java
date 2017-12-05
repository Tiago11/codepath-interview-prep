public class Solution {
	public int lengthOfLongestSubstring(String a) {

	    char[] arr = a.toCharArray();

	    String longestSub = null;
	    int longestLength = 0;

	    LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

	    for (int i = 0; i < a.length(); i++) {

	        char c = arr[i];

	        if (!map.containsKey(c)) {

	            map.put(c, i);

	        } else {

	            i = map.get(c);
	            map.clear();

	        }

	        if (map.size() > longestLength) {
	            longestLength = map.size();
	            longestSub = map.keySet().toString();
	        }
	    }

	    return longestLength;
	}
}
