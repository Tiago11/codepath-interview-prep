public class Solution {
    public String longestPalindrome(String A) {

        if (A == null || A.length() <= 1) {
            return A;
        }

        int lenA = A.length();
        boolean[][] dp = new boolean[lenA][lenA];

        int maxLen = 1;
        int start = 0;

        for (int l = 0; l < lenA; l++) {
            for (int i = 0; i < lenA-l; i++) {
                int j = l + i;

                if (A.charAt(i) == A.charAt(j) && ((j-i <= 2) || (dp[i+1][j-1]))) {
                    dp[i][j] = true;

                    if (l+1 > maxLen) {
                        maxLen = l+1;
                        start = i;
                    }
                }
            }
        }

        return A.substring(start, start+maxLen);
    }
}
