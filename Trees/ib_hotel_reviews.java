public class Solution {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        String[] words = A.split("_");
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int maxCount = 0;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < B.size(); i++) {
            String s = B.get(i);

            int currCount = 0;
            String[] w = s.split("_");
            for (int j = 0; j < w.length; j++) {
                if (trie.search(w[j])) {
                    currCount++;
                }
            }

            if (currCount > maxCount) {
                maxCount = currCount;
            }

            if (currCount < minCount) {
                minCount = currCount;
            }

            if (map.containsKey(currCount)) {
                List<Integer> vector = map.get(currCount);
                vector.add(i);
            } else {
                List<Integer> vector = new ArrayList<Integer>();
                vector.add(i);
                map.put(currCount, vector);
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = maxCount; i >= minCount; i--) {
            if (map.containsKey(i)) {
                if (map.get(i).size() == 1) {
                    res.add(map.get(i).get(0));
                } else {
                    List<Integer> vector = map.get(i);
                    int[] arr = new int[vector.size()];
                    for (int k = 0; k < arr.length; k++) {
                        arr[k] = vector.get(k);
                    }
                    Arrays.sort(arr);

                    for (int k = 0; k < arr.length; k++) {
                        res.add(arr[k]);
                    }
                }
            }
        }

        return res;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String s) {
        HashMap<Character, TrieNode> children = this.root.children;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            TrieNode t;
            if (children.containsKey(ch)) {
                t = children.get(ch);
            } else {
                t = new TrieNode(ch);
                children.put(ch, t);
            }

            children = t.children;

            if (i == s.length()-1) {
                t.isLeaf = true;
            }
        }
    }

    public boolean search(String s) {
        HashMap<Character, TrieNode> children = this.root.children;

        TrieNode t = null;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (children.containsKey(ch)) {
                t = children.get(ch);
                children = t.children;
            } else {
                return false;
            }
        }

        if (t != null && t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }
}

class TrieNode {
    char ch;
    HashMap<Character, TrieNode> children;
    boolean isLeaf;

    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isLeaf = false;
    }

    public TrieNode(Character c) {
        this.ch = c;
        this.children = new HashMap<Character, TrieNode>();
        this.isLeaf = false;
    }
}
