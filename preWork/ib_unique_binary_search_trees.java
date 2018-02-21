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
	public ArrayList<TreeNode> generateTrees(int a) {

	    if (a == 0) {
	        return new ArrayList<TreeNode>();
	    }

	    return generateTrees(1, a);
	}

	public ArrayList<TreeNode> generateTrees(int min, int max) {
	    ArrayList<TreeNode> res = new ArrayList<TreeNode>();

	    if (min > max) {
	        res.add(null);
	        return res;
	    }

	    for (int i = min; i <= max; i++) {
	        ArrayList<TreeNode> ls = generateTrees(min, i-1);
	        ArrayList<TreeNode> rs = generateTrees(i+1, max);

	        for (TreeNode l : ls) {
	            for (TreeNode r : rs) {
	                TreeNode curr = new TreeNode(i);
	                curr.left = l;
	                curr.right = r;

	                res.add(curr);
	            }
	        }
	    }

	    return res;
	}
}
