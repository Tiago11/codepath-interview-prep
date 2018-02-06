public class Solution {
    public int climbStairs(int A) {

        if (A == 0) {
            return 0;
        }

        int[] aux = new int[A+1];
        aux[0] = 1;
        aux[1] = 1;

        for (int i = 2; i <= A; i++) {
            aux[i] = aux[i-1] + aux[i-2];
        }

        return aux[A];
    }
}
