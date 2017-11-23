/*
Find the kth smallest element in an unsorted array of non-negative integers.

Definition of kth smallest element

 kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
NOTE
You are not allowed to modify the array ( The array is read only ).
Try to do it using constant extra space.

Example:

A : [2 1 4 3 2]
k : 3

answer : 2
*/

// Java 7.
public int kthsmallest(final int[] A, int B) {

        // Check if the array A is null or empty.
        if (A == null || A.length == 0) {
          throw new IllegalArgumentException("Array A is null or empty");
        }

        // Check if B is non-negative.
        if (B <= 0) {
          throw new IllegalArgumentException("B must be non-negative and it is: " + B);
        }

        // Check if B is smaller than the amount of elements of A.
        if (A.length < B) {
          throw new IllegalArgumentException("B can't be greater than the amount of elements of A");
        }

        int lo = 0;
        int hi = Integer.MAX_VALUE;

        // Since we don't know the maximum value the array can have, we do
        // binary search on the [0, MAX_INT] range. This way we satisfy the
        // O(1) space requirement.
        // While doing binary search, we keep track of the amount of numbers smaller
        // than B and equal than B. We use that information to find the
        // B-smallest number in the array.
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int lessCounter = 0, equalCounter = 0;

            for(int i = 0; i < A.length; i++) {
                if(A[i] < mid) {
                    lessCounter++;
                }else if(A[i] == mid) {
                    equalCounter++;
                }
                if(lessCounter >= B) break;
            }

            if(lessCounter < B && lessCounter + equalCounter >= B){
                return mid;
            }else if(lessCounter >= B) {
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return -1;
    }
