public class Solution {
    public int wordBreak(String A, ArrayList<String> B) {

        if (A.length() == 0 || B.size() == 0) {
            return 0;
        }

        Set<String> dict = new HashSet<String>(B);

        boolean[] dp = new boolean[A.length()];
        Arrays.fill(dp, false);

        for (int i = 0; i < A.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if ((j == 0 || dp[j-1]) && dict.contains(A.substring(j, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return (dp[A.length()-1]) ? 1 : 0;
    }
}
