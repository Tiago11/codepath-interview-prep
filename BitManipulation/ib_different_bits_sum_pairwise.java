public class Solution {
    public int cntBits(ArrayList<Integer> A) {

        int[] ones = new int[32];

        for (Integer x : A) { // Important to make the two loops in this order, first each element, and then each bit of that element.
            for (int i = 0; i < 32; i++) {
                ones[i] += (x & 1);
                x = x >> 1;
            }
        }

        long sum = 0; // Important to declare this as long!!!
        for (int i = 0; i < 32; i++) {
            sum += ((long)ones[i]*(A.size()-ones[i])) % 1000000007;
        }

        return (int)(sum*2 % 1000000007); // Important to cast the result after the modulo operation!!!
    }

}
