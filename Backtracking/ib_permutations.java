public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        Collections.sort(A);

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        permuteRec(A, 0, res);

        return res;
    }

    public void permuteRec(ArrayList<Integer> A, int start, ArrayList<ArrayList<Integer>> res) {
        if (start >= A.size()) {
            ArrayList<Integer> list = new ArrayList<Integer>(A);
            res.add(list);
        }

        for (int i = start; i <= A.size()-1; i++) {
            swap(A, start, i);
            permuteRec(A, start+1, res);
            swap(A, start, i);
        }
    }

    public void swap(ArrayList<Integer> A, int i, int j) {
        int tmp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, tmp);
    }
}
