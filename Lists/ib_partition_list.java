/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode partition(ListNode a, int b) {

	    ListNode less = null;
	    ListNode greater = null;

	    ListNode l = less;
	    ListNode g = greater;

	    ListNode p = a;
	    while (p != null) {
	        if (p.val < b) {

	            if (l == null) {
	                less = new ListNode(p.val);
	                l = less;
	            } else {
	                ListNode node = new ListNode(p.val);
    	            l.next = node;
    	            l = l.next;
	            }

	        } else {

	            if (g == null) {
	                greater = new ListNode(p.val);
	                g = greater;
	            } else {
	                ListNode node = new ListNode(p.val);
	                g.next = node;
	                g = g.next;
	            }

	        }

	        p = p.next;
	    }

	    if (less == null) {
	        return greater;
	    } else if (greater == null) {
	        return less;
	    } else {
	        p = less;
	        while (p.next != null) {
	            p = p.next;
	        }
	        p.next = greater;

	        return less;
	    }
	}
}
