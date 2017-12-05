import java.math.BigInteger;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int atoi(final String A) {

        StringBuilder sb = new StringBuilder("");
        boolean firstDigitRead = false;
        boolean isNegative = false;
        boolean plusSymbolFound = false;

        for (int i = 0; i < A.length(); i++) {

            if (Character.isDigit(A.charAt(i))) {
                sb.append(A.charAt(i));
                if (!firstDigitRead) {
                    firstDigitRead = true;
                }
            } else if (!firstDigitRead && !Character.isWhitespace(A.charAt(i))) {

                if (A.charAt(i) == '-') {
                    isNegative = true;
                    firstDigitRead = true;
                } else if (A.charAt(i) == '+') {
                    plusSymbolFound = true;
                    firstDigitRead = true;
                } else {
                    return 0;
                }
            } else if (firstDigitRead && !Character.isDigit(A.charAt(i))) {
                break;
            }

        }

        if (sb.length() == 0 && (isNegative || plusSymbolFound)) {
            return 0;
        }

        BigInteger num = new BigInteger(sb.toString());
        //long num = Long.parseLong(sb.toString());
        if (isNegative) {
            num = num.negate();
        }

        if (BigInteger.valueOf(Integer.MAX_VALUE).compareTo(num) < 0) {
            return Integer.MAX_VALUE;
        } else if (BigInteger.valueOf(Integer.MIN_VALUE).compareTo(num) > 0) {
            return Integer.MIN_VALUE;
        } else {
            return num.intValue();
        }

    }
}
