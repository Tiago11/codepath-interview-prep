public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {

        if (A == null || A.size() == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < A.size(); i++) {
            res += Math.max(0, A.get(i) - A.get(i-1));
        }

        return res;
    }
}
