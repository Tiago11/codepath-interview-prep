public class Solution {

    Map<Integer, Integer> map;
    Deque<Integer> q;
    int capacity;

    public Solution(int capacity) {
        this.map = new HashMap<Integer, Integer>();
        this.q = new LinkedList<Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            q.removeFirstOccurrence(key);
            q.addFirst(key);
            return map.get(key);
        } else {
            return -1;
        }

    }

    public void set(int key, int value) {

        if (map.containsKey(key)) {
            map.put(key, value);
            q.removeFirstOccurrence(key);
            q.addFirst(key);
        } else {
            if (map.size() == this.capacity) {
                int lruKey = q.removeLast();
                map.remove(lruKey);
            }

            map.put(key, value);
            q.addFirst(key);
        }

    }
}


/*******************************************************************************
    Solution using LinkedHashMap
*******************************************************************************/
/*
public class Solution {

    LinkedHashMap<Integer, Integer> map;
    final int capacity;

    public Solution(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, (float)0.75, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                return (size() > capacity);
            }
        };
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}
*/
