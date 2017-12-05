/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {

        ListNode slow = A;
        ListNode fast = A;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        mid = reverse(mid);
        ListNode head = A;

        while (mid != null && head.val == mid.val) {
            head = head.next;
            mid = mid.next;
        }

        if (mid == null) {
            return 1;
        } else {
            return 0;
        }
    }

    public ListNode reverse(ListNode A) {

        ListNode p1 = A;
        ListNode p2 = p1.next;

        while (p1 != null && p2 != null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        A.next = null;
        ListNode p = (p2 == null ? p1 : p2);

        return p;
    }
}
