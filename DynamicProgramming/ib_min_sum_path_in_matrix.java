public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {

        if (A.size() == 0) {
            return 0;
        }

        int M = A.size();
        int N = A.get(0).size();

        int[][] mem = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j != 0) {
                    mem[i][j] = A.get(i).get(j) + mem[i][j-1];
                } else if (i != 0 && j == 0) {
                    mem[i][j] = A.get(i).get(j) + mem[i-1][j];
                } else if (i == 0 && j == 0) {
                    mem[i][j] = A.get(0).get(0);
                } else {
                    mem[i][j] = A.get(i).get(j) + Math.min(mem[i-1][j], mem[i][j-1]);
                }
            }
        }

        return mem[M-1][N-1];
    }
}
