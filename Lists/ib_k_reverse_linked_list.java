/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {

        if (A == null || A.next == null || B <= 1) {
            return A;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode p = A;
        ListNode pre = dummy;
        int i = 0;

        while (p != null) {

            i++;

            if (i % B == 0) {
                pre = reverse(pre, p.next);
                p = pre.next;
            } else {
                p = p.next;
            }

        }

        return dummy.next;
    }

    public ListNode reverse(ListNode pre, ListNode next) {

        ListNode last = pre.next;
        ListNode curr = last.next;

        while (curr != next) {
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }

        return last;
    }
}
