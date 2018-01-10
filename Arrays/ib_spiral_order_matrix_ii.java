public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {

        int[][] matrix = new int[A][A];

        int rowStart = 0;
        int rowEnd = A-1;
        int colStart = 0;
        int colEnd = A-1;

        int counter = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = counter;
                counter++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = counter;
                counter++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart; i--) {
                matrix[rowEnd][i] = counter;
                counter++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {
                matrix[i][colStart] = counter;
                counter++;
            }
            colStart++;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < matrix[i].length; j++) {
                row.add(matrix[i][j]);
            }
            res.add(row);
        }

        return res;
    }
}
