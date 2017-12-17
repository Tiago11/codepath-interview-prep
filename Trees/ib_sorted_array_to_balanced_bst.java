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
	public TreeNode sortedArrayToBST(final List<Integer> a) {

	    int[] arr = new int[a.size()];
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = a.get(i);
	    }

	    if (a == null || a.size() == 0) {
	        return null;
	    }

	    return buildBST(arr, 0, arr.length-1);
	}

	public TreeNode buildBST(int[] arr, int start, int end) {
	    if (start > end) {
	        return null;
	    }

	    int mid = (start + end)/2;

	    TreeNode root = new TreeNode(arr[mid]);

	    root.left = buildBST(arr, start, mid-1);
	    root.right = buildBST(arr, mid+1, end);

	    return root;
	}
}
