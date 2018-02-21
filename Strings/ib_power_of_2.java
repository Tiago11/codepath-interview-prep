import java.math.*;

public class Solution {
    public int power(String A) {

        if ("1".equals(A)) {
            return 0;
        }

        BigInteger biA = new BigInteger(A);
        String binaryA = biA.toString(2);

        int countSetBit = 0;

        for (int i = 0; i < binaryA.length(); i++) {
            if (biA.testBit(i)) {
                countSetBit++;
            }
        }

        return (countSetBit == 1) ? 1 : 0;
    }
}
