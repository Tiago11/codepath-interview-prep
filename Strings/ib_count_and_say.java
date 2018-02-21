public class Solution {
    public String countAndSay(int A) {

        if (A == 0) {
            return new String("");
        }

        if (A == 1) {
            return new String("1");
        }

        String num = "1";
        for (int i = 2; i <= A; i++) {
            num = getNextNum(num);
        }

        return num;
    }

    public String getNextNum(String num) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;

        while (i < num.length()) {
            char digit = num.charAt(i);
            int count = 1;
            i++;

            while (i < num.length() && num.charAt(i) == digit) {
                count++;
                i++;
            }

            sb.append(Character.forDigit(count, 10));
            sb.append(digit);
        }

        return sb.toString();
    }
}
