public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {

        if (A.size() == 1) {
            return 0;
        }

        int maxDiff;
        int i;
        int j;

        int[] rMax = new int[A.size()];
        int[] lMin = new int[A.size()];

        lMin[0] = A.get(0);
        for (int l = 1; l < A.size(); l++) {
            lMin[l] = Math.min(A.get(l), lMin[l-1]);
        }

        rMax[A.size()-1] = A.get(A.size()-1);
        for (int m = A.size()-2; m >=0; m--) {
            rMax[m] = Math.max(A.get(m), rMax[m+1]);
        }

        i = 0;
        j = 0;
        maxDiff = -1;
        while (i < A.size() && j < A.size()) {
            if (lMin[i] <= rMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else {
                i  = i + 1;
            }
        }

        return maxDiff;
    }
}
