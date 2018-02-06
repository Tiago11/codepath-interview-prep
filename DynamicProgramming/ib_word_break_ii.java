public class Solution {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {

        if (A.length() == 0 || B.size() == 0) {
            return new ArrayList<String>();
        }

        Map<String, ArrayList<String>> mem = new HashMap<String, ArrayList<String>>();
        Set<String> dict = new HashSet<String>(B);

        return wordBreakRec(A, dict, mem);
    }

    private ArrayList<String> wordBreakRec(String A, Set<String> dict, Map<String, ArrayList<String>> mem) {

        if (mem.containsKey(A)) {
            return mem.get(A);
        }

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < A.length(); i++) {
            String prefix = A.substring(0, i+1);

            if (dict.contains(prefix)) {
                if (i != A.length()-1) {

                    for (String str : wordBreakRec(A.substring(i+1), dict, mem)) {
                        result.add(prefix + " " + str);
                    }

                } else {
                    result.add(prefix);
                }
            }
        }

        mem.put(A, result);
        return result;
    }
}
