public class Solution {
    public int maxArr(ArrayList<Integer> A) {

        int maxPlus = Integer.MIN_VALUE;
        int minPlus = Integer.MAX_VALUE;

        int maxMinus = Integer.MIN_VALUE;
        int minMinus = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            maxPlus = Math.max(maxPlus, A.get(i) + i);
            minPlus = Math.min(minPlus, A.get(i) + i);

            maxMinus = Math.max(maxMinus, A.get(i) - i);
            minMinus = Math.min(minMinus, A.get(i) - i);
        }

        int res = 0;
        res = Math.max(res, maxPlus - minPlus);
        res = Math.max(res, maxMinus - minMinus);

        return res;
    }
}
