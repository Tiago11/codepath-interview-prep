public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isScramble(final String A, final String B) {

        Map<String, Set<String>> mem = new HashMap<String, Set<String>>();

        return isScrambleRec(A, B, mem) ? 1 : 0;
    }

    private boolean isScrambleRec(String A, String B, Map<String, Set<String>> mem) {

        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            if (mem.containsKey(A)) {
                mem.get(A).add(B);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(B);
                mem.put(A, set);
            }
            return true;
        }

        if (!isAnagram(A, B)) {
            return false;
        }

        for (int i = 1; i < A.length(); i++) {
            String ss11 = A.substring(0, i);
            String ss12 = A.substring(i);
            String ss21 = B.substring(0, i);
            String ss22 = B.substring(i);
            String ss23 = B.substring(0, B.length()-i);
            String ss24 = B.substring(B.length()-i);

            if ((isScrambleRec(ss11, ss21, mem) && isScrambleRec(ss12, ss22, mem)) ||
                (isScrambleRec(ss11, ss24, mem) && isScrambleRec(ss12, ss23, mem))) {

                if (mem.containsKey(A)) {
                    mem.get(A).add(B);
                } else {
                    Set<String> set = new HashSet<String>();
                    set.add(B);
                    mem.put(A, set);
                }

                return true;
            }
        }

        return false;
    }

    private boolean isAnagram(String A, String B) {
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        String sortedA = new String(arrA);
        String sortedB = new String(arrB);

        return sortedA.equals(sortedB);
    }
}
