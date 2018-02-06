public class Solution {
    public int numDecodings(String A) {

        if (A.charAt(0) == '0') {
            return 0;
        }

        int[] aux = new int[A.length()+1];
        aux[0] = 1;
        aux[1] = 1;

        for (int i = 2; i <= A.length(); i++) {

            aux[i] = 0;
            if (A.charAt(i-1) != '0') {
                aux[i] = aux[i-1];
            }

            if (A.charAt(i-2) == '1' || A.charAt(i-2) == '2' &&
                    Character.getNumericValue(A.charAt(i-1)) < 7) {
                aux[i] += aux[i-2];
            }

        }

        return aux[A.length()];
    }
}
