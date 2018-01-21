public class Solution {
	public ArrayList<ArrayList<String>> partition(String a) {

	    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

	    if (a == null || a.length() == 0) {
	        return res;
	    }

	    ArrayList<String> part = new ArrayList<String>();
	    addPalindrome(a, 0, part, res);

	    return res;
	}

	private void addPalindrome(String s, int start, ArrayList<String> part,
	                                ArrayList<ArrayList<String>> res) {
	    if (start == s.length()) {
	        ArrayList<String> tmp = new ArrayList<String>(part);
	        res.add(tmp);
	        return;
	    }

	    for (int i = start + 1; i <= s.length(); i++) {
	        String str = s.substring(start, i);
	        if (isPalindrome(str)) {
	            part.add(str);
	            addPalindrome(s, i, part, res);
	            part.remove(part.size()-1);
	        }
	    }
	}

	private boolean isPalindrome(String str) {
	    int left = 0;
	    int right = str.length()-1;

	    while (left < right) {
	        if (str.charAt(left) != str.charAt(right)) {
	            return false;
	        }

	        left++;
	        right--;
	    }

	    return true;
	}
}
