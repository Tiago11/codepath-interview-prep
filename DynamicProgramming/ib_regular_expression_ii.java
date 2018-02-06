public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {

        boolean[][] dp = new boolean[A.length()+1][B.length()+1];
        dp[0][0] = true;

        for (int i = 1; i <= A.length(); i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= B.length(); j++) {
            if (j != 1 && dp[0][j-2]) {
                dp[0][j] = true;
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {

                if ((A.charAt(i-1) == B.charAt(j-1) || B.charAt(j-1) == '.') && dp[i-1][j-1]) {
                    dp[i][j] = true;
                } else if (j != 1 && B.charAt(j-1) == '*' && ((dp[i][j-2]) || (dp[i][j-1] && (A.charAt(i-1) == B.charAt(j-2) || B.charAt(j-2) == '.')) || (dp[i-1][j] && (A.charAt(i-1) == B.charAt(j-2) || B.charAt(j-2) == '.' || B.charAt(j-2) == '*')))) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }

            }
        }

        return dp[A.length()][B.length()] ? 1 : 0;
    }
}
