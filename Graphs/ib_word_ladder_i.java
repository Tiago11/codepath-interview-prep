public class Solution {

    public class Node {
        String word;
        int numSteps;

        public Node(String word, int numSteps) {
            this.word = word;
            this.numSteps = numSteps;
        }
    }

	public int ladderLength(String start, String end, ArrayList<String> dictV) {

	    Queue<Node> q = new LinkedList<Node>();
	    q.add(new Node(start, 1));

	    dictV.add(end);
	    Set<String> set = new HashSet<String>(dictV);

	    while (!q.isEmpty()) {
	        Node top = q.remove();
	        String word = top.word;

	        if (word.equals(end)) {
	            return top.numSteps;
	        }

	        char[] arr = word.toCharArray();
	        for (int i = 0; i < arr.length; i++) {
	            for (char c='a'; c <= 'z'; c++) {
	                char tmp = arr[i];
	                if (arr[i] != c) {
	                    arr[i] = c;
	                }

	                String newWord = new String(arr);
	                if (set.contains(newWord)) {
	                    q.add(new Node(newWord, top.numSteps+1));
	                    set.remove(newWord);
	                }

	                arr[i] = tmp;
	            }
	        }
	    }

	    return 0;
	}
}
