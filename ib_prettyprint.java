// user: s363962@mvrht.net
// pass: 12345678

/******************************************************************************
Print concentric rectangular pattern in a 2d matrix.
Let us show you some examples to clarify what we mean.

Example 1:

Input: A = 4.
Output:

4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4
Example 2:

Input: A = 3.
Output:

3 3 3 3 3
3 2 2 2 3
3 2 1 2 3
3 2 2 2 3
3 3 3 3 3
The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
*******************************************************************************/
// Java 7.
public int[][] prettyPrint(int A) {

        // Check if A > 0.
        if (A <= 0) {
          throw new IllegalArgumentException("A must be non-negative and it is: " + A);
        }

        // Size of the result matrix.
        int size = 2*A - 1;
        int[][] res = new int[size][size];

        int start = 0;
        int end = size;
        int current = A;

        // The iteration will build the concentric squares from the outside in.
        // The first iteration fills the outer square with A, the next one
        // fills the immediate inner square with A-1, and so on until putting 1
        // in the center.
        for (int k = 0; k < size; k++) {

            for (int i = start; i < end; i++) {
                res[k][i] = current;            // Upper side of square.
                res[size - 1 - k][i] = current; // Lower side of square.
                // Avoid overwriting cells.
                if (i != start && i != end-1) {
                  res[i][k] = current;            // Left side of square.
                  res[i][size - 1 - k] = current; // Right side of square.
                }
            }

            // Update the variables before the new iteration.
            start++;
            end--;
            current--;
        }

        return res;
    }
