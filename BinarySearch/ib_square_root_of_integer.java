public class Solution {
	public int sqrt(int a) {

	    if (a == 0 || a == 1) {
	        return a;
	    }

	    int start = 0;
	    int end = a/2;

	    int ans = 0;

	    while (start <= end) {

	        long mid = (start + end)/2;

	        if (mid*mid == a) {
	            return (int)mid;
	        }

	        if (mid*mid < a) {
	            start = (int)mid+1;
	            ans = (int)mid;
	        } else {
	            end = (int)mid - 1;
	        }
	    }

	    return ans;
	}
}
