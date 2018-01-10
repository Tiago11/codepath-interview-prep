public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {

        int curr = A.get(0);
        int max = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            curr = Math.max(A.get(i), curr + A.get(i));
            max = Math.max(max, curr);
        }

        return max;
    }
}
