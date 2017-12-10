/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {

	    if (a == null) {
	        return b;
	    }

	    if (b == null) {
	        return a;
	    }

	    int carry = 0;
	    int value = a.val + b.val;
	    if (value >= 10) {
	        carry = 1;
	        value = value % 10;
	    }
	    ListNode res = new ListNode(value);
	    ListNode l = res;

	    ListNode A = a.next;
	    ListNode B = b.next;

	    while (A != null && B != null) {
	        value = A.val + B.val + carry;
	        if (value >= 10) {
	            carry = 1;
	            value = value % 10;
	        } else {
	            carry = 0;
	        }

	        l.next = new ListNode(value);
	        l = l.next;

	        A = A.next;
	        B = B.next;
	    }

	    if (A == null && B == null && carry == 1) {
	        l.next = new ListNode(carry);
	    } else if (A == null) {
	        while (B != null) {
	            value = B.val + carry;
	            if (value >= 10) {
	                carry = 1;
	                value = value % 10;
	            } else {
	                carry = 0;
	            }
	            l.next = new ListNode(value);
	            l = l.next;

	            B = B.next;
	        }

	        if (carry == 1) {
	            l.next = new ListNode(carry);
	        }

	    } else if (B == null) {
	        while (A != null) {
	            value = A.val + carry;
	            if (value >= 10) {
	                carry = 1;
	                value = value % 10;
	            } else {
	                carry = 0;
	            }
	            l.next = new ListNode(value);
	            l = l.next;

	            A = A.next;
	        }

	        if (carry == 1) {
	            l.next = new ListNode(carry);
	        }
	    }

	    return res;
	}
}
