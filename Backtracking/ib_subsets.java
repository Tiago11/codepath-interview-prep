public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        Collections.sort(A);

        ArrayList<ArrayList<Integer>> res = subsetsRec(A);

        Collections.sort(res, ArrayListComparatorSize);
        Collections.sort(res, ArrayListComparatorElems);

        return res;
    }

    public ArrayList<ArrayList<Integer>> subsetsRec(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (A.size() == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<Integer> list = new ArrayList<Integer>(A);
        Integer head = list.get(0);
        ArrayList<Integer> rest = new ArrayList<Integer>(list.subList(1, list.size()));
        for (ArrayList<Integer> set : subsetsRec(rest)) {
            ArrayList<Integer> newSet = new ArrayList<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            res.add(newSet);
            res.add(set);
        }
        return res;
    }

    public static Comparator<ArrayList<Integer>> ArrayListComparatorSize = new Comparator<ArrayList<Integer>>() {
        public int compare(ArrayList<Integer> one, ArrayList<Integer> two) {
            return one.size()-two.size();
        }
    };

    public static Comparator<ArrayList<Integer>> ArrayListComparatorElems = new Comparator<ArrayList<Integer>>() {
        public int compare(ArrayList<Integer> one, ArrayList<Integer> two) {
            if (one.size() == 0) {
                return -1;
            }

            if (two.size() == 0) {
                return 1;
            }

            int i = 0;
            int j = 0;

            while (i < one.size() && j < two.size() && one.get(i) == two.get(j)) {
                i++;
                j++;
            }

            if (i == one.size()) {
                return -1;
            } else if (j == two.size()) {
                return 1;
            } else {
                Integer oneInt = one.get(i);
                Integer twoInt = two.get(j);

                return oneInt.compareTo(twoInt);
            }
        }
    };
}
