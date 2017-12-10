/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode reverseBetween(ListNode a, int m, int n) {

	    if (a == null || a.next == null || m >= n) {
	        return a;
	    }

	    ListNode dummy = new ListNode(0);
	    dummy.next = a;

	    ListNode pre = dummy;
	    ListNode l = a;
	    int i = 1;

	    while (i < n) {

	        if (i < m) {
	            pre = pre.next;
	        }

	        l = l.next;
	        i++;

	    }

	    ListNode next = l.next;

	    ListNode last = pre.next;
	    ListNode curr = last.next;

	    while (curr != next) {
	        last.next = curr.next;
	        curr.next = pre.next;
	        pre.next = curr;
	        curr = last.next;
	    }

	    return dummy.next;
	}
}
