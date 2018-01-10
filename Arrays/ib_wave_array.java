public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {

        Collections.sort(A);

        for (int i = 0; i < A.size()-1; i+=2) {
            swap(A, i, i+1);
        }

        return A;
    }

    private void swap(ArrayList<Integer> A, int i, int j) {
        int tmp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, tmp);
    }
}
