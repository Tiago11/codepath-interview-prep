public class Solution {
    public ArrayList<Integer> flip(String A) {

        int[] countOnes = new int[A.length()];
        int[] startingIndex = new int[A.length()];

        int counter;

        if (A.charAt(0) == '1') {
            countOnes[0] = -1;
            counter = 0;
        } else {
            countOnes[0] = 1;
            counter = 1;
        }
        startingIndex[0] = 0;

        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) == '1') {
                counter--;
            } else {
                counter++;
            }

            if (counter < 0) {
                countOnes[i] = -1;
                counter = 0;
                startingIndex[i] = i;
            } else {
                countOnes[i] = counter;
                if (countOnes[i-1] < 0) {
                    startingIndex[i] = i;
                } else {
                    startingIndex[i] = startingIndex[i-1];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < A.length(); i++) {
            if (countOnes[i] > max) {
                max = countOnes[i];
                maxIndex = i;
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (max > 0) {
            int l = startingIndex[maxIndex] + 1;
            int r = maxIndex + 1;
            res.add(l);
            res.add(r);
        }

        return res;
    }
}
