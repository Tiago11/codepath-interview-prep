public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {

        if (B.length() == 1 && B.charAt(0) == '*') {
            return 1;
        }

        boolean[][] dp = new boolean[A.length()+1][B.length()+1];
        dp[0][0] = true;

        for (int i = 1; i <= A.length(); i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= B.length(); j++) {
            if (B.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i-1) == B.charAt(j-1) && dp[i-1][j-1]) {
                    dp[i][j] = true;
                } else if (B.charAt(j-1) == '?' && dp[i-1][j-1]) {
                    dp[i][j] = true;
                } else if (B.charAt(j-1) == '*') {

                    if (dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }

                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[A.length()][B.length()] ? 1 : 0;
    }
}
