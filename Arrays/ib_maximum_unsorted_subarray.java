public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

        Stack<Integer> stack = new Stack<Integer>();
        int l = A.size();
        int r = 0;

        for (int i = 0; i < A.size(); i++) {
            while (!stack.empty() && A.get(stack.peek()) > A.get(i)) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();

        for (int i = A.size()-1; i >= 0; i--) {
            while (!stack.empty() && A.get(stack.peek()) < A.get(i)) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (r - l > 0) {
            res.add(l);
            res.add(r);
        } else {
            res.add(-1);
        }

        return res;
    }
}
