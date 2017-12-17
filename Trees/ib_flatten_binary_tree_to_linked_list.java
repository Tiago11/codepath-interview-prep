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
	public TreeNode flatten(TreeNode a) {
	    if (a == null) {
	        return null;
	    }

	    TreeNode tmpL = a.left;
	    TreeNode tmpR = a.right;
	    a.left = null;
	    a.right = flatten(tmpL);
	    if (a.right == null) {
	        a.right = flatten(tmpR);
	    } else {
	        TreeNode aux = a.right;
	        while (aux.right != null) {
	            aux = aux.right;
	        }

	        aux.right = flatten(tmpR);
	    }

	    return a;
	}
}
