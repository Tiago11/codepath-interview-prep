public class Solution {
    public int findMinXor(ArrayList<Integer> A) {

        Collections.sort(A);

        int xor = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < A.size(); i++) {
            xor = A.get(i-1) ^ A.get(i);
            if (xor < min) {
                min = xor;
            }
        }

        return min;
    }
}
