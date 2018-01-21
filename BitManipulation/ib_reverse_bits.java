public class Solution {

	public long reverse(long a) {
	    for (int i = 0; i < 16; i++) {
	        a = swapBits(a, i, 32 - i - 1);
	    }

	    return a;
	}

	public long swapBits(long a, int i, int j) {
	    long x = (a >> i) & 1;
	    long y = (a >> j) & 1;

	    x = x & 0xFFFFFFFFL;
	    y = y & 0xFFFFFFFFL;

	    if ((x ^ y) != 0) {
	        a ^= ((1 << i) | (1 << j));
	        a = a & 0xFFFFFFFFL;
	    }

	    return a;
	}
}

/*
		The idea behind this algorithm is to swap the first bit with the last bit,
		and keep doing that in a outer-in fashion.
		We check for every pair of bits:
			- We get the bits by shifting and AND(&) to 1.
			- Then we check if they are different by doing XOR(^) to them.
				- If they are different, we have to switch each of them.
					We do that by doing XOR(^) to 1, that assures that the bit will change.
					So, we have to create a mask with only one in the places we want to change.
		Something important we have to do in this problem is to emulate a 32 bit
		unsigned integer from a long. We do that by zeroing the 32 most significant bits
		of the long. Then, every time we calculate a new long value we AND(&) it with the
		following mask: 0xFFFFFFFFL that represents the number with the most significant
		32 bits to zero and the following 32 bits to 1.
		That's how we make sure to stay in range.
*/
