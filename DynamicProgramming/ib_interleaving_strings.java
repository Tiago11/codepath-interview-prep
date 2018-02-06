public class Solution {
    public int isInterleave(String A, String B, String C) {

        if (A.length() + B.length() != C.length()) {
            return 0;
        }

        boolean[][] dp = new boolean[A.length()+1][B.length()+1];
        dp[0][0] = true;

        for (int i = 1; i <= A.length(); i++) {
            dp[i][0] = (dp[i-1][0] && A.charAt(i-1) == C.charAt(i-1));
        }

        for (int j = 1; j <= B.length(); j++) {
            dp[0][j] = (dp[0][j-1] && B.charAt(j-1) == C.charAt(j-1));
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                dp[i][j] = (dp[i-1][j] && A.charAt(i-1) == C.charAt(i+j-1) ||
                                dp[i][j-1] && B.charAt(j-1) == C.charAt(i+j-1));
            }
        }

        return dp[A.length()][B.length()] ? 1 : 0;
    }
}
