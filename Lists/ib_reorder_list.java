/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode reorderList(ListNode a) {

	    if (a == null || a.next == null) {
	        return a;
	    }

	    ListNode fast = a;
	    ListNode slow = a;

	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }

	    ListNode pre = new ListNode(0);
	    pre.next = slow;
	    ListNode rev = reverse(pre);

	    ListNode l = a;
	    int size = 1;
	    ListNode tmp;

	    while (l.next != null) {

	        if (size % 2 == 0) {

	            tmp = rev.next;
	            rev.next = l;
	            rev = tmp;

	        } else {

	            tmp = l.next;
	            l.next = rev;
	            l = tmp;
	        }

	        size++;
	    }

	    return a;
	}

	public ListNode reverse(ListNode pre) {

	    ListNode last = pre.next;
	    ListNode curr = last.next;

	    while (curr != null) {
	        last.next = curr.next;
	        curr.next = pre.next;
	        pre.next = curr;
	        curr = last.next;
	    }

	    return pre.next;

	    /*
	    *** RECURSIVE SOLUTION, doesn't work on interviewBit.
	    ***

	    if (head == null) {
	        return null;
	    }

	    if (head.next == null) {
	        return head;
	    }

	    ListNode tmp = head.next;
	    head.next = null;

	    ListNode res = reverse(tmp);

	    tmp.next = head;

	    return res;
	    */


	}
}
