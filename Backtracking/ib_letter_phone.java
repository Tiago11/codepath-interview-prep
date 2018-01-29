public class Solution {
    public ArrayList<String> letterCombinations(String A) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "0");

        ArrayList<String> res = new ArrayList<String>();

        if (A == null || A.length() == 0) {
            return res;
        }

        ArrayList<Character> tmp = new ArrayList<Character>();
        getLetterCombs(A, tmp, res, map);

        return res;
    }

    private void getLetterCombs(String A, ArrayList<Character> tmp, ArrayList<String> res,
                                    HashMap<Integer, String> map) {

        if (A.length() == 0) {
            char[] arr = new char[tmp.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = tmp.get(i);
            }
            res.add(new String(arr));
            return;
        }

        Integer curr = Integer.valueOf(A.substring(0,1));
        String letters = map.get(curr);
        for (int i = 0; i < letters.length(); i++) {
            tmp.add(letters.charAt(i));
            getLetterCombs(A.substring(1), tmp, res, map);
            tmp.remove(tmp.size()-1);
        }

    }
}
