public class Solution {

    private int min3(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    public int minDistance(String A, String B) {

        if (A.equals(B)) {
            return 0;
        }

        int M = A.length();
        int N = B.length();

        int[][] dp = new int[M+1][N+1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = min3(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[M][N];
    }
}
