public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> diag;

        for (int i = 0; i < A.size(); i++) {
            diag = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                diag.add(A.get(j).get(i-j));
            }
            diagonals.add(diag);
        }

        for (int i = 1; i < A.size(); i++) {
            diag = new ArrayList<Integer>();
            for (int j = A.size()-1; j >= i; j--) {
                diag.add(A.get(i + (A.size()-1 - j)).get(j));
            }
            diagonals.add(diag);
        }

        return diagonals;
    }
}
