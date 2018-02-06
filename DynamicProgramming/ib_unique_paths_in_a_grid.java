public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {

        if (A == null || A.size() == 0 || A.get(0).size() == 0) {
            return 0;
        }

        int M = A.size();
        int N = A.get(0).size();

        if (A.get(M-1).get(N-1) == 1) {
            return 0;
        }

        int[][] dp = new int[M][N];
        dp[0][0] = 1;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i > 0 && A.get(i-1).get(j) == 0) {
                    dp[i][j] += dp[i-1][j];
                }

                if (j > 0 && A.get(i).get(j-1) == 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }

        return dp[M-1][N-1];
    }
}
