public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {

        if (A == null || A.size() == 0) {
            return 0;
        }

        int res = 0;
        int min = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            res = Math.max(res, A.get(i) - min);
            min = Math.min(min, A.get(i));
        }

        return res;
    }
}
