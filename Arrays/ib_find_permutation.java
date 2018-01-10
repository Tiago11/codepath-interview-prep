public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        int min = 1;
        int max = B;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'I') {
                res.add(min);
                min++;
            } else if (A.charAt(i) == 'D') {
                res.add(max);
                max--;
            }
        }

        res.add(min);

        return res;
    }
}
