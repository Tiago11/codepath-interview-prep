public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {

        int single = 0;

        for (Integer x : A) {
            single = single ^ x;
        }

        return single;
    }
}
