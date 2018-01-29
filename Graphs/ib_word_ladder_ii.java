public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {

	    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	    ArrayList<String> path = new ArrayList<String>();
	    path.add(start);

	    HashSet<String> dictWords = new HashSet<String>(dict);
	    dictWords.add(end);

	    Queue<ArrayList<String>> q = new LinkedList<ArrayList<String>>();
	    q.add(path);

	    while (!q.isEmpty()) {
	        path = q.remove();
	        String lastWord = path.get(path.size()-1);

	        if (lastWord.equals(end)) {
	            res.add(path);
	        } else {

	            char[] arr = lastWord.toCharArray();
	            for (int i = 0; i < arr.length; i++) {
	                for (char c = 'a'; c <= 'z'; c++) {
	                    char tmp = arr[i];
	                    if (arr[i] != c) {
	                        arr[i] = c;

	                        String nextWord = new String(arr);
	                        if (dictWords.contains(nextWord) && !isWordInCurrPath(nextWord, path)) {
	                            ArrayList<String> newPath = new ArrayList<String>(path);
	                            newPath.add(nextWord);

	                            q.add(newPath);
	                        }

	                        arr[i] = tmp;
	                    }
	                }
	            }
	        }
	    }

	    int min = Integer.MAX_VALUE;
	    for (ArrayList<String> p : res) {
	        if (p.size() < min ) {
	            min = p.size();
	        }
	    }

	    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    for (ArrayList<String> p : res) {
	        if (p.size() == min) {
	            result.add(p);
	        }
	    }

	    return result;
	}

	private boolean isWordInCurrPath(String word, ArrayList<String> path) {
	    for (String s : path) {
	        if (word.equals(s)) {
	            return true;
	        }
	    }

	    return false;
	}
}
