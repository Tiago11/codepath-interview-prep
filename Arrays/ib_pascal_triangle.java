public class Solution {
    public int[][] generate(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i <= A; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);

            for (int j = 1; j < i-1; j++) {

                row.add(res.get(i-2).get(j-1) + res.get(i-2).get(j));

            }

            if (i != 1) {
                row.add(1);
            }

            //for (Integer x : row) {
            //    System.out.print(x + " ");
            //}
            //System.out.println();

            res.add(row);
        }

        int[][] arr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                arr[i][j] = res.get(i).get(j);
            }
        }

        return arr;
    }
}
