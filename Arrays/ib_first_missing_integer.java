public class Solution {
    public int firstMissingPositive(int[] A) {

        // Find max and min in array.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }

            if (A[i] > 0 && A[i] < min) {
                min = A[i];
            }
        }

        if (max <= 0 || min > 1) {
            return 1;
        }

        boolean[] range = new boolean[max-min+1];
        for (int i = 0; i < range.length; i++) {
            range[i] = false;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= min) {
                range[A[i]-min] = true;
            }
        }

        int j = 0;
        while (j < range.length && range[j]) {
            j++;
        }
        int missingInt = j + min;

        return missingInt;
    }
}
