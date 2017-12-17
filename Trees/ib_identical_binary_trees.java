/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int isSameTree(TreeNode a, TreeNode b) {

	    if (a != null && b == null) {
	        return 0;
	    }

	    if (a == null && b != null) {
	        return 0;
	    }

	    if (a == null && b == null) {
	        return 1;
	    }

	    if (a.val != b.val) {
	        return 0;
	    }

	    return Math.min(isSameTree(a.left, b.left), isSameTree(a.right, b.right));
	}
}
