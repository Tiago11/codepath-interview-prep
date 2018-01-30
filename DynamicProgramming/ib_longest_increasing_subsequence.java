public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {

        if (A.size() == 0) {
            return 0;
        }

        int[] arr = new int[A.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && arr[i] < arr[j]+1) {
                    arr[i] = arr[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}
