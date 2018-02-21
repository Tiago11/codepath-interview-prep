public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {

        if (A.length() == 0 || B.length() == 0 || A.length() < B.length()) {
            return -1;
        }

        int lenA = A.length();
        int lenB = B.length();

        int[] kmpTable = createKmpTable(B, lenB);

        int i = 0;
        int j = 0;

        while (i < lenA) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            }

            if (j == lenB) {
                return i-j;
            } else if (i < lenA && A.charAt(i) != B.charAt(j)) {
                if (j != 0) {
                    j = kmpTable[j-1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    public int[] createKmpTable(String B, int lenB) {
        int[] t = new int[lenB];
        t[0] = 0;

        int i = 1;
        int len = 0;

        while (i < lenB) {
            if (B.charAt(len) == B.charAt(i)) {
                len++;
                t[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = t[len-1];
                } else {
                    t[i] = 0;
                    i++;
                }
            }
        }

        return t;
    }
}
