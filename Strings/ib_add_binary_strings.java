public class Solution {
    public String addBinary(String A, String B) {

        if ((A == null && B == null) || (A.length() == 0 && B.length() == 0)) {
            return new String("");
        } else if (A == null && B != null || A.length() == 0 && B.length() != 0) {
            return B;
        } else if (A != null && B == null || A.length() != 0 && B.length() == 0) {
            return A;
        }

        StringBuilder sb = new StringBuilder("");
        int carry = 0;
        int i = A.length()-1;
        int j = B.length()-1;

        while (i >= 0 && j >= 0) {
            int curr = carry + Character.getNumericValue(A.charAt(i)) + Character.getNumericValue(B.charAt(j));
            if (curr == 2) {
                carry = 1;
                curr = 0;
            } else if (curr == 3) {
                carry = 1;
                curr = 1;
            } else {
                carry = 0;
            }

            sb.append(Character.forDigit(curr, 10));
            i--;
            j--;
        }

        while (i >= 0) {
            int curr = carry + Character.getNumericValue(A.charAt(i));

            if (curr == 2) {
                curr = 0;
                carry = 1;
            } else {
                carry = 0;
            }

            sb.append(Character.forDigit(curr, 10));
            i--;
        }

        while (j >= 0) {
            int curr = carry + Character.getNumericValue(B.charAt(j));
            if (curr == 2) {
                curr = 0;
                carry = 1;
            } else {
                carry = 0;
            }

            sb.append(Character.forDigit(curr, 10));
            j--;
        }

        if (carry == 1) {
            sb.append("1");
        }

        sb.reverse();
        return sb.toString();
    }
}
