/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {

	    if (a == null) {
	        return b;
	    }

	    if (b == null) {
	        return a;
	    }

	    ListNode head;
	    if (a.val < b.val) {
	        head = a;
	        a = a.next;
	    } else {
	        head = b;
	        b = b.next;
	    }

	    ListNode l = head;

	    while (a != null && b != null) {

	        if (a.val < b.val) {
	            l.next = a;
	            a = a.next;
	        } else {
	            l.next = b;
	            b = b.next;
	        }

	        l = l.next;
	    }

	    if (a == null) {
	        l.next = b;
	    } else {
	        l.next = a;
	    }

	    return head;
	}
}
