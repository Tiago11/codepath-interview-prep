public class Solution {
    public int romanToInt(String A) {

        if (A == null || A.length() == 0) {
            return 0;
        }

        int res = 0;
        int i = 0;
        while (i < A.length()) {
            int v1 = getIntValue(A.charAt(i));

            if (i+1 < A.length()) {
                int v2 = getIntValue(A.charAt(i+1));

                if (v1 >= v2) {
                    res = res + v1;
                } else {
                    res = res + v2 - v1;
                    i++;
                }
            } else {
                res = res + v1;
            }

            i++;
        }

        return res;
    }

    private int getIntValue(Character c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
