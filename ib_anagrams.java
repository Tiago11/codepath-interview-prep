public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

	    ArrayList<ArrayList<Integer>> anagrams = new ArrayList<ArrayList<Integer>>();
	    Map<String, Integer> map = new HashMap<String, Integer>();

	    for (int i = 0; i < a.size(); i++) {
	        String s = a.get(i);
	        char[] arr = s.toCharArray();

	        Arrays.sort(arr);
	        s = new String(arr);

	        if (map.containsKey(s)) {

	            int anagramIndex = map.get(s);
	            anagrams.get(anagramIndex).add(i+1);

	        } else {

	            map.put(s, anagrams.size());
	            ArrayList<Integer> newAnagram = new ArrayList<Integer>();
	            newAnagram.add(i+1);
	            anagrams.add(newAnagram);

	        }

	    }

        return anagrams;
	}
}
