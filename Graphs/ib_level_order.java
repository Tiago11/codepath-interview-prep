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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();

        if (A == null) {
            return res;
        }

        Queue<TreeNode> qCurr = new LinkedList<TreeNode>();
        Queue<TreeNode> qNext = new LinkedList<TreeNode>();
        qCurr.add(A);

        while (!qCurr.isEmpty()) {

            TreeNode node = qCurr.remove();

            if (node.left != null) {
                qNext.add(node.left);
            }

            if (node.right != null) {
                qNext.add(node.right);
            }

            level.add(node.val);
            if (qCurr.isEmpty()) {
                qCurr = qNext;
                qNext = new LinkedList<TreeNode>();
                res.add(level);
                level = new ArrayList<Integer>();
            }
        }

        return res;
    }
}
