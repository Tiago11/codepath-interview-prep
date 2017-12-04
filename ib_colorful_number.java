public class Solution {
    public int colorful(int A) {

        String s = String.valueOf(A);
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }

        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        boolean colorful = true;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                int value = 1;

                for (int k = i; k <= j; k++) {
                    value *= arr[k];
                }

                if (map.containsKey(value)) {
                    colorful = false;
                    break;
                } else {
                    map.put(value, true);
                }
            }
        }

        if (colorful) {
            return 1;
        } else {
            return 0;
        }
    }
}
