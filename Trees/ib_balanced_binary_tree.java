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
	public int isBalanced(TreeNode a) {
	    if (a == null) {
	        return 1;
	    }

	    if ((Math.abs(getHeight(a.left) - getHeight(a.right)) <= 1) && isBalanced(a.left) == 1 && isBalanced(a.right) == 1) {
	        return 1;
	    } else {
	        return 0;
	    }
	}

	public int getHeight(TreeNode a) {
	    if (a == null) {
	        return 0;
	    }

	    return Math.max(getHeight(a.left), getHeight(a.right)) + 1;
	}
}
