public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {

        if (a == null) {
            return null;
        }

        if (a.size() == 0) {
            return a;
        }

        ArrayList<Integer> sum = new ArrayList<Integer>();
        sum.add(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            sum.add(sum.get(i-1) + a.get(i));
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxLength = 0;
        int currLength = 0;
        int maxStartIndex = -1;
        int maxEndIndex = -2;

        for (int i = 0; i < sum.size(); i++) {

            if (sum.get(i) == 0) {
                currLength = i+1;
                if (currLength > maxLength) {
                    maxLength = currLength;
                    maxStartIndex = 0;
                    maxEndIndex = i;
                }

            } else {

                if (map.containsKey(sum.get(i))) {

                    currLength = i - map.get(sum.get(i));
                    if (currLength > maxLength) {
                        maxLength = currLength;
                        maxStartIndex = map.get(sum.get(i)) + 1;
                        maxEndIndex = i;
                    }

                } else {
                    map.put(sum.get(i), i);
                }

            }

        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = maxStartIndex; i <= maxEndIndex; i++) {
            res.add(a.get(i));
        }

        return res;
    }
}
