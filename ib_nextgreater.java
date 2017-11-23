/*******************************************************************************
Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
More formally,

G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exist, consider next greater element as -1.

Example:

Input : A : [4, 5, 2, 10]
Output : [5, 10, 10, -1]

Example 2:

Input : A : [3, 2, 1]
Output : [-1, -1, -1]
*******************************************************************************/
// Java 7.
// Auxiliary class used to store array element value and index in a stack.
public class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public int[] nextGreater(int[] A) {

    // Check if A is null or empty.
    if (A == null || A.length == 0) {
        throw new IllegalArgumentException("Array A is null or empty.");
    }

    // Initialize result array.
    int[] res = new int[A.length];

    // We add values to the stack and check if the current element is the
    // next greater element of the elements of the stack.
    Stack<Pair> stack = new Stack();
    Pair pair = new Pair(A[0], 0);
    stack.push(pair);

    // Start from the second element.
    for (int i = 1; i < A.length; i++) {

        while (!stack.empty() && (stack.peek()).first < A[i]) {
            pair = stack.pop();
            res[pair.second] = A[i];
        }

        stack.push(new Pair(A[i], i));
    }

    // The remaining elements on the stack will have a -1 as a next greater element.
    while (!stack.empty()) {
        pair = stack.pop();
        res[pair.second] = -1;
    }

    return res;
}
