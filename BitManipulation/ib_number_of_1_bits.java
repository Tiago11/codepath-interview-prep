public class Solution {
	public int numSetBits(long a) {

	    int sum = 0;

	    while (a > 0) {
	        sum++;
	        a = a & (a-1);
	    }

	    return sum;
	}
}
