public class Solution {
	public int pow(int x, int n, int d) {

	    if (x == 0 && n == 0) {
	        return 0;
	    }

	    if (n == 0) {
	        return 1;
	    }

	    long tmp = pow(x, n/2, d) % d;

	    if (n % 2 == 0) {
	        long res = ((tmp % d) * (tmp % d) % d);
	        return (int) res;
	    } else {
	        long rem = (x % d);
            if (rem < 0) {
                rem += d;
            }

            long aux = (((tmp % d) * (tmp % d)) % d);
            long res = ((rem % d) * (aux % d) % d);
            return (int) (res % d);
	    }
	}
}
