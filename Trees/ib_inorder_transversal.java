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
	public ArrayList<Integer> inorderTraversal(TreeNode a) {

	    ArrayList<Integer> res = new ArrayList<Integer>();

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode node = a;

	    while (node != null) {
	        stack.push(node);
	        node = node.left;
	    }

	    while (!stack.empty()) {

	        node = stack.pop();
	        res.add(node.val);

	        if (node.right != null) {
	            node = node.right;
	            while (node != null) {
	                stack.push(node);
	                node = node.left;
	            }
	        }

	    }


	    return res;
	}

}
