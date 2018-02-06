public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        /*
        int[] x = new int[A.get(0).size()+1];
        int[] y = new int[A.get(0).size()+1];
        x[0] = 0;
        y[0] = 0;

        for (int i = 1; i <= A.get(0).size(); i++) {
            int val = Math.max(A.get(0).get(i-1), A.get(1).get(i-1));

            x[i] = val + y[i-1];
            y[i] = Math.max(x[i-1], y[i-1]);
        }

        return Math.max(x[A.get(0).size()], y[A.get(0).size()]);
        */

        int x = 0;
        int y = 0;

        for (int i = 0; i < A.get(0).size(); i++) {
            int val = Math.max(A.get(0).get(i), A.get(1).get(i));

            int tmp = x;
            x = val + y;
            y = Math.max(tmp, y);
        }

        return Math.max(x, y);
    }
}
