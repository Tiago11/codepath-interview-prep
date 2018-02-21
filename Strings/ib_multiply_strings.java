public class Solution {
    public String multiply(String A, String B) {
        if ("0".equals(A) || "0".equals(B)) {
            return new String("0");
        }

        if ("1".equals(A)) {
            return new String(B);
        }

        if ("1".equals(B)) {
            return new String(A);
        }

        if(A.equals("0") || B.equals("0")) return "0";

        A = removeZerosAtTheBeggining(A);
        B = removeZerosAtTheBeggining(B);

        return solve(A,B);

        //System.out.println(A);
        //System.out.println(B);
        /*
        int len1 = A.length();
        int len2 = B.length();
        int[] cache = new int[len1 + len2 -1];
        for(int i = len1-1; i >= 0; i--){
            int d1 = A.charAt(i) - '0';
            int startIndex = len1 - i - 1;
            for(int j = len2-1; j >= 0; j--){
                int d2 = B.charAt(j) - '0';
                cache[startIndex++] += d1*d2;
            }
        }
        for(int i = 0; i < cache.length-1; i++){
            cache[i+1] += cache[i]/10;
            cache[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int d = cache[cache.length-1];
        if(d >= 10){
            sb.append(d/10);
            cache[cache.length-1] = d%10;
        }
        for(int i = cache.length-1; i >= 0; i--){
            sb.append((char)(cache[i] + '0'));
        }

        return sb.toString();
        */
    }

    public String removeZerosAtTheBeggining(String num) {
        if (num.charAt(0) != '0') {
            return num;
        }

        int index = 0;
        while (index < num.length() && num.charAt(index) == '0') {
            index++;
        }

        return num.substring(index);
    }

    public String solve(String A, String B) {

        StringBuilder res = new StringBuilder("0");
        int i = A.length()-1;
        int j = B.length()-1;

        for (int k = B.length()-1; k >= 0; k--) {
            String aux = multiplyByOneDigit(A, B.charAt(k));
            StringBuilder sbAux = new StringBuilder(aux);
            for (int z = k; z < B.length()-1; z++) {
                sbAux.append("0");
            }

            res = new StringBuilder(sum(res.toString(), sbAux.toString()));
        }

        return res.toString();
    }

    public String multiplyByOneDigit(String A, Character c) {
        int d = Character.getNumericValue(c);

        if (d == 0 || "0".equals(A)) {
            return new String("0");
        }

        if (d == 1) {
            return new String(A);
        }

        if ("1".equals(A)) {
            return Character.toString(c);
        }

        StringBuilder sb = new StringBuilder("");
        int carry = 0;
        for (int i = A.length()-1; i >= 0; i--) {
            int curr = carry + (d*Character.getNumericValue(A.charAt(i)));
            if (curr >= 10) {
                carry = curr / 10;
                curr = curr % 10;
            } else {
                carry = 0;
            }

            sb.append(Character.forDigit(curr,10));
        }

        if (carry != 0) {
            sb.append(Character.forDigit(carry,10));
        }

        sb.reverse();
        return sb.toString();
    }

    public String sum(String A, String B) {
        if ("0".equals(A)) {
            return new String(B);
        }

        if ("0".equals(B)) {
            return new String(A);
        }

        int i = A.length()-1;
        int j = B.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        while (i >= 0 && j >= 0) {
            int curr = carry + Character.getNumericValue(A.charAt(i)) + Character.getNumericValue(B.charAt(j));
            if (curr >= 10) {
                carry = curr / 10;
                curr = curr % 10;
            } else {
                carry = 0;
            }

            sb.append(Character.forDigit(curr,10));

            i--;
            j--;
        }

        while (i >= 0) {
            int curr = carry + Character.getNumericValue(A.charAt(i));
            if (curr >= 10) {
                carry = curr / 10;
                curr = curr % 10;
            } else {
                carry = 0;
            }

            sb.append(Character.forDigit(curr,10));

            i--;
        }

        while (j >= 0) {
            int curr = carry + Character.getNumericValue(B.charAt(j));
            if (curr >= 10) {
                carry = curr / 10;
                curr = curr % 10;
            } else {
                carry = 0;
            }

            sb.append(Character.forDigit(curr,10));

            j--;
        }

        if (carry != 0) {
            sb.append(Character.forDigit(carry,10));
        }

        sb.reverse();
        return sb.toString();
    }

}
