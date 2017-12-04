/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {

	    if (a == null || a.next == null) {
	        return a;
	    }

	    ListNode l = a;

	    while (l.next != null) {

	        if (l.val == l.next.val) {
	            l.next = l.next.next;
	        } else {
	            l = l.next;
	        }

	    }

	    return a;
	}
}
