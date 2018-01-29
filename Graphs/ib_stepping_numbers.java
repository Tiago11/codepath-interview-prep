public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {

        if (A < 0) {
            A = 0;
        }

        if (B < 0) {
            B = 0;
        }

        if (A > B) {
            A = 0;
            B = 0;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i < 10; i++) {
            q.add(i);
        }

        return bfs(A, B, q);
    }

    private ArrayList<Integer> bfs(int A, int B, Queue<Integer> q) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == 0) {
            res.add(0);
        }

        while (!q.isEmpty()) {
            Integer x = q.remove();

            if (A <= x && x <= B) {
                res.add(x);
            }

            int lastDigit = x % 10;

            if (lastDigit != 0) {
                int leftChild = x*10 + (lastDigit-1);
                if (leftChild <= B) {
                    q.add(leftChild);
                }
            }

            if (lastDigit != 9) {
                int rightChild = x*10 + (lastDigit+1);
                if (rightChild <= B) {
                    q.add(rightChild);
                }
            }
        }

        return res;
    }
}
