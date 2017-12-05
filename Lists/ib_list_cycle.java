/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {

	    if (a == null || a.next == null) {
	        return null;
	    }

	    ListNode l = a;
	    ListNode p = a;
	    boolean first = true;

	    while ((l != p || first) && p != null && p.next != null) {
	        first = false;
	        l = l.next;
	        p = p.next.next;
	    }

	    if (l == p) {

	        ListNode q = a;
	        while (q != l) {
	            q = q.next;
	            l = l.next;
	        }

	        return q;
	    } else {
	        return null;
	    }

	}
}
