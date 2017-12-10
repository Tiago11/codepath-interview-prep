public class Solution {
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {

	    ArrayList<Integer> indexes = new ArrayList<Integer>();

	    int wordsHash = 0;
	    for (String s : b) {
	        wordsHash += s.hashCode();
	    }

	    int subLength = b.size() * b.get(0).length();
	    for (int i = 0; i <= a.length()-subLength; i++) {

	        String sub = a.substring(i, i+subLength);
	        List<String> b2 = new ArrayList<String>(b);

	        int subHash = 0;
	        for (int j = 0; j < sub.length(); j+=b.get(0).length()) {
	            String subSub = sub.substring(j, j+b.get(0).length());
	            if (b2.indexOf(subSub) != -1) {
	                subHash += subSub.hashCode();
	                b2.remove(subSub);
	            } else {
	                subHash = 0;
	                break;
	            }
	        }

	        if (subHash == wordsHash) {
	            indexes.add(i);
	        }
	    }

	    return indexes;
	}
}
