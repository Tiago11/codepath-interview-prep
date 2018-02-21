public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isNumber(final String A) {
        String pat = "\\s*(\\+|-)?\\d*\\.?\\d+(e(\\+|-)?\\d+)?\\s*";

        return (A.matches(pat)) ? 1 : 0;
    }
}
