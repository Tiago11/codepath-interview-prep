public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {

        int xor = 0;

        for (int i = 0; i < A.size(); i++) {
            xor = xor ^ A.get(i);
            xor = xor ^ (i+1);
        }

        int rmstSetBit = xor & ~(xor-1);

        int x = 0;
        int y = 0;

        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) & rmstSetBit) > 0) {
                x = x ^ A.get(i);
            }

            if (((i+1) & rmstSetBit) > 0) {
                x = x ^ (i+1);
            }
        }

        y = xor ^ x;

        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == x) {
                res.add(x);
                res.add(y);

                return res;
            }
        }

        res.add(y);
        res.add(x);

        return res;

    }
}
