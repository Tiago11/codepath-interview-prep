/*
Given a singly linked list, modify the value of first half nodes such that :

1st node’s new value = the last node’s value - first node’s current value
2nd node’s new value = the second last node’s value - 2nd node’s current value,
and so on …

 NOTE :
If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5,

You should return 4 -> 2 -> 3 -> 4 -> 5
as

for first node, 5 - 1 = 4
for second node, 4 - 2 = 2
Try to solve the problem using constant extra space.
*/

// Java 7.
public ListNode subtract(ListNode A) {

        // Check if list is empty or if it has only one element.
        if (A == null || A.next == null) {
            return A;
        }

        ListNode m = A;
        ListNode l = A;

        // Find the middle of the list. By the end of this loop, m will have a
        // reference to the middle of the list.
        while (l != null && l.next != null) {
            m = m.next;
            l = l.next.next;
        }

        ListNode p = m;

        // Move p depending if the length of the list is odd or even.
        if (l != null) {
            p = p.next;
        }

        // Put the values of the seconde half of the list into a stack.
        Stack<Integer> stack = new Stack<Integer>();
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        // Use the values from the stack to substract from the first half of the
        // list.
        l = A;
        while (l != m) {
            l.val = stack.pop() - l.val;
            l = l.next;
        }

        // return the pointer to the head of the list.
        return A;
    }
