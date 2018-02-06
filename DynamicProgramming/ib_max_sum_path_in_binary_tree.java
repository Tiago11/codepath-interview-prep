/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {

    public class IntWrapper {
        int max;

        public IntWrapper() {
            this.max = Integer.MIN_VALUE;
        }
    }

    public int maxPathSum(TreeNode A) {

        if (A == null) {
            return 0;
        }

        IntWrapper iw = new IntWrapper();
        maxPathSumRec(A, iw);

        return iw.max;
    }

    private int maxPathSumRec(TreeNode root, IntWrapper iw) {
        if (root == null) {
            return 0;
        }

        int leftRes = maxPathSumRec(root.left, iw);
        int rightRes = maxPathSumRec(root.right, iw);

        int current = Math.max(root.val, Math.max(leftRes + root.val, root.val + rightRes));

        iw.max = Math.max(iw.max, Math.max(current, leftRes + root.val + rightRes));

        return current;
    }
}
