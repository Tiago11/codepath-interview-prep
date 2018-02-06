public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {

        if (A.size() == 0 || A.get(0).size() == 0) {
            return 0;
        }

        int M = A.size();
        int N = A.get(0).size();

        int[][] aux = new int[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                aux[i][j] = A.get(i-1).get(j-1) + aux[i-1][j] + aux[i][j-1] - aux[i-1][j-1];
            }
        }


        int counter = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = i; k <= M; k++) {
                    for (int l = j; l <= N; l++) {
                        if (aux[k][l] - aux[k][j-1] - aux[i-1][l] + aux[i-1][j-1] == 0) {
                            counter++;
                        }
                    }
                }
            }
        }

        return counter;
    }
}
