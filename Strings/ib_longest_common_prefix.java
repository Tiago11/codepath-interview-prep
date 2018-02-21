public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {

        if (A == null || A.size() == 0) {
            return new String("");
        }

        if (A.size() == 1) {
            return A.get(0);
        }

        for (String s : A) {
            if (s.length() == 0) {
                return new String("");
            }
        }

        StringBuilder sb = new StringBuilder("");

        int i = 0;
        boolean foundPrefix = false;
        boolean endString = false;
        boolean missmatch = false;

        while (!foundPrefix) {

            if (A.get(0).length()-1 == i) {
                endString = true;
            }

            char c = A.get(0).charAt(i);

            for (int j = 1; j < A.size(); j++) {
                if (A.get(j).charAt(i) != c) {
                    missmatch = true;
                }

                if (A.get(j).length()-1 == i) {
                    endString = true;
                }
            }

            if (!missmatch) {
                sb.append(c);
            }

            if (missmatch || endString) {
                foundPrefix = true;
            }

            i++;
        }

        return sb.toString();
    }
}
