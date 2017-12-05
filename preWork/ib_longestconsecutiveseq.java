/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example:
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

// Java 7.
public int longestConsecutive(final int[] A) {

        // Check if A is null or empty.
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Array A is null or empty.");
        }

        // Variable to count the length of the longest sequence.
        int longestSeq = 0;

        // We add the elements to a HashSet, this allows us to find an
        // element in O(1) (average).
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            hashSet.add(A[i]);
        }

        // We check for each element if it is the smaller of a possible sequence.
        // If it is, we calculate how long is the longest sequence starting from it.
        int currentSeq = 0;
        for (Integer elem : hashSet) {
            if (!hashSet.contains(elem-1)) {
                int currentNum = elem;
                currentSeq = 1;

                while (hashSet.contains(currentNum+1)) {
                    currentSeq++;
                    currentNum++;
                }

                if (currentSeq > longestSeq) {
                    longestSeq = currentSeq;
                }
                currentSeq = 0;
            }
        }

        return longestSeq;
    }
