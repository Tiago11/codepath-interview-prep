public class Solution {
    public ArrayList<String> restoreIpAddresses(String A) {
        if (A.length() < 4 || A.length() > 12) {
            return new ArrayList<String>();
        }

        int lenA = A.length();
        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < lenA; i++) {
            for (int j = i+1; j < lenA; j++) {
                for (int k = j+1; k < lenA; k++) {
                    StringBuilder sb = new StringBuilder("");
                    sb.append(A.substring(0,i+1));
                    sb.append(".");
                    sb.append(A.substring(i+1, j+1));
                    sb.append(".");
                    sb.append(A.substring(j+1, k+1));
                    sb.append(".");
                    sb.append(A.substring(k+1, lenA));

                    if (isValidIp(sb.toString())) {
                        res.add(sb.toString());
                    }
                }
            }
        }

        return res;
    }

    private boolean isValidIp(String ip) {
        String[] parts = ip.split("\\.");

        if (parts.length != 4) {
            return false;
        }

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() == 0) {
                return false;
            }

            if (parts[i].charAt(0) == '0' && parts[i].length() > 1) {
                return false;
            }

            if (Integer.valueOf(parts[i]) > 255) {
                return false;
            }
        }

        return true;
    }
}
