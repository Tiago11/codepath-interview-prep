public class Solution {
    public ArrayList<Integer> getRow(int A) {

        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);

        for (int i = 1; i <= A; i++) {
            for (int j = i-2; j >= 0; j--) {
                int tmp = row.get(j+1) + row.get(j);
                row.set(j+1, tmp);
            }
            row.add(1);
        }

        return row;
    }
}
