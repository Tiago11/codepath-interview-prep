/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> a) {

	    TreeMap<Integer, ListNode> pq = new TreeMap<Integer, ListNode>();
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	    for (int i = 0; i < a.size(); i++) {

	        ListNode l = a.get(i);

	        while (l != null) {

	            if (map.containsKey(l.val)) {
	                map.put(l.val, map.get(l.val) + 1);
	            } else {
	                map.put(l.val, 1);
	            }

	            pq.put(l.val, l);
	            l = l.next;
	        }
	    }

	    ListNode dummy = new ListNode(0);
	    ListNode l = dummy;

	    while (pq.size() > 0) {
	        int minKey = pq.firstKey();
	        l.next = pq.get(minKey);
	        l = l.next;

	        if (map.get(minKey) > 1) {

	            for (int i = 1; i < map.get(minKey); i++) {
	                l.next = new ListNode(minKey);
	                l = l.next;
	            }

	        }

	        pq.remove(minKey);
	    }

	    return dummy.next;
	}
}
