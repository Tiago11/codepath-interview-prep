public class Solution {
    public int divide(int A, int B) {

        if (B == 0) {
            return Integer.MAX_VALUE;
        }

        if (A == Integer.MIN_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositiveResult = ((A < 0) ^ (B < 0) == false);

        long dividend = Math.abs((long)A);
        long divisor = Math.abs((long)B);

        int res = 0;

        while (dividend >= divisor) {
            long tmp = divisor;
            int multiple = 1;
            while (dividend >= (tmp << 1)) {
                tmp = tmp << 1;
                multiple = multiple << 1;
            }
            dividend -= tmp;
            res += multiple;
        }

        return isPositiveResult ? res : -1*res;
    }

    /*
    ANOTHER WAY, MORE STRAIGHT FORWARD!!!
    public int divide(int A, int B) {

        if (B == 0) {
            return Integer.MAX_VALUE;
        }

        if (A == Integer.MIN_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositiveResult = ((A < 0) ^ (B < 0) == false);

        long dividend = Math.abs((long)A);
        long divisor = Math.abs((long)B);

        int res = 0;
        while (dividend > 0) {
            dividend -= divisor;
            res++;
        }

        if (dividend < 0) {
            res--;
        }

        return isPositiveResult ? res : -1*res;
    }
    */
}
