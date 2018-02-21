import java.math.*;

public class Solution {
    public int compareVersion(String A, String B) {

        String[] arrA = A.split("\\.");
        String[] arrB = B.split("\\.");
        int i = 0;

        while (i < arrA.length && i < arrB.length) {
            BigInteger numA = new BigInteger(arrA[i]);
            BigInteger numB = new BigInteger(arrB[i]);
            if (numA.compareTo(numB) == 1) {
                return 1;
            } else if (numA.compareTo(numB) == -1) {
                return -1;
            } else {
                i++;
            }
        }

        if (i == arrA.length && i == arrB.length) {
            return 0;
        } else if (i == arrA.length) {
            if (arrB.length-1 == i && "0".equals(arrB[i])) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (arrA.length-1 == i && "0".equals(arrA[i])) {
                return 0;
            } else {
                return 1;
            }
        }

    }
}
