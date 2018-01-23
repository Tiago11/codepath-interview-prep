/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    //static ListNode h;

    public class ListWrapper {
        public ListNode head;

        public ListWrapper(ListNode l) {
            this.head = l;
        }
    }

	public TreeNode sortedListToBST(ListNode a) {

	    if (a == null) {
	        return null;
	    }

	    ListWrapper lw = new ListWrapper(a);
	    int listLength = getListLength(a);
	    return sortedListToBstRec(0, listLength-1, lw);
	}

	private TreeNode sortedListToBstRec(int start, int end, ListWrapper lw) {
	    if (start > end) {
	        return null;
	    }

	    int mid = (end + start)/2;

	    TreeNode left = sortedListToBstRec(start, mid-1, lw);
	    TreeNode root = new TreeNode(lw.head.val);
	    lw.head = lw.head.next;
	    TreeNode right = sortedListToBstRec(mid+1, end, lw);

	    root.left = left;
	    root.right = right;

	    return root;
	}

	private int getListLength(ListNode a) {
	    ListNode head = a;
	    int len = 0;

	    while (head != null) {
	        len++;
	        head = head.next;
	    }

	    return len;
	}
}
