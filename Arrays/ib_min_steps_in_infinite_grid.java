public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int totalDist = 0;

        int x1 = A.get(0);
        int y1 = B.get(0);

        for (int i = 0; i < A.size(); i++) {
            int x2 = A.get(i);
            int y2 = B.get(i);

            totalDist += dist(x1, y1, x2, y2);

            x1 = x2;
            y1 = y2;
        }

        return totalDist;
    }

    private int dist(int x1, int y1, int x2, int y2) {
        if (Math.abs(x1 - x2) > Math.abs(y1 - y2)) {
            return Math.abs(x1 - x2);
        } else {
            return Math.abs(y1 - y2);
        }
    }
}
