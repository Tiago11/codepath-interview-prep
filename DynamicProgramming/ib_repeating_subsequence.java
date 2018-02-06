public class Solution {
    public int anytwo(String A) {

        Set<String> set = new HashSet<String>();

        for (int i = 0; i < A.length(); i++) {
            for (int j = i+1; j < A.length(); j++) {
                char[] arr = new char[2];
                arr[0] = A.charAt(i);
                arr[1] = A.charAt(j);
                String ss = new String(arr);

                if (!set.contains(ss) && isPresentSubSequence(ss, i, j, A)) {
                    return 1;
                } else {
                    set.add(ss);
                }
            }
        }

        return 0;
    }

    private boolean isPresentSubSequence(String ss, int s, int e, String A) {

        for (int i = s+1; i < A.length(); i++) {
            for (int j = i+1; j < A.length(); j++) {
                if (j != e && ss.charAt(0) == A.charAt(i) && ss.charAt(1) == A.charAt(j)) {
                    return true;
                }
            }
        }

        return false;
    }
}
