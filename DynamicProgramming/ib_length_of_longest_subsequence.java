public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {

        if (A.size() == 0) {
            return 0;
        }

        int[] lis = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < lis.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && lis[i] < lis[j]+1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int[] lds = new int[A.size()];
        for (int i = 0; i < lds.length; i++) {
            lds[i] = 1;
        }

        for (int i = lds.length-2; i >= 0; i--) {
            for (int j = lds.length-1; j > i; j--) {
                if (A.get(i) > A.get(j) && lds[i] < lds[j]+1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int max = lis[0] + lds[0] - 1;
        for (int i = 1; i < lis.length; i++) {
            if (lis[i] + lds[i] - 1 > max) {
                max = lis[i] + lds[i] - 1;
            }
        }

        return max;
    }
}
