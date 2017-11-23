/*******************************************************************************
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example :
[1,1,2] have the following unique permutations:

[1,1,2]
[1,2,1]
[2,1,1]
 NOTE : No 2 entries in the permutation sequence should be the same.
*******************************************************************************/
// Java 7.
public int[][] permute(int[] A) {

        // Check if A is null or empty.
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Array A is null or empty.");
        }

        // Collection where we are going to put all the unique permutations.
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // Array to check if an element of the array was already used in
        // the current permutation.
        boolean[] numsUsed = new boolean[A.length];

        List<Integer> l = new ArrayList<Integer>();
        Arrays.sort(A);

        // Recursively generate all the unique permutations.
        permuteUnique(A, numsUsed, l, res);

        // Transform the collection into a primitive matrix.
        int[][] m = toIntArray(res);
        return m;
    }

    // Auxiliary function that build all the unique permutations of A recursively.
    private void permuteUnique(int[] A, boolean[] numsUsed, List<Integer> l, List<List<Integer>> res) {

        // If the current permutation has the same length as the original array
        // we finished building the current permutation.
        if (l.size() == A.length) {
            res.add(new ArrayList<Integer>(l));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (!numsUsed[i]) {
                if (i <= 0 || A[i-1] != A[i] || numsUsed[i-1]) {
                    numsUsed[i] = true;
                    l.add(A[i]);
                    permuteUnique(A, numsUsed, l, res);
                    numsUsed[i] = false;
                    l.remove(l.size()-1);
                }
            }
        }
    }

    // Auxiliary function to transform a List<List<Integer>> into an int[][].
    private int[][] toIntArray(List<List<Integer>> m)  {
        int[][] res = new int[m.size()][m.get(0).size()];

        int row = 0;
        int column = 0;

        for (List<Integer> l : m) {
            for (Integer i : l) {
                res[row][column] = i.intValue();
                column++;
            }
            row++;
            column = 0;
        }

        return res;
    }
