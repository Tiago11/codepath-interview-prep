public class Solution {
    public String intToRoman(int A) {

        Map<Integer, String> values = new HashMap<Integer,String>();
        values.put(1000, "M");
        values.put(900, "CM");
        values.put(500, "D");
        values.put(400, "CD");
        values.put(100, "C");
        values.put(90, "XC");
        values.put(50, "L");
        values.put(40, "XL");
        values.put(10, "X");
        values.put(9, "IX");
        values.put(5, "V");
        values.put(4, "IV");
        values.put(1, "I");

        StringBuilder sb = new StringBuilder("");
        Set keySet = values.keySet();
        List<Integer> keys = new ArrayList<Integer>(keySet);
        Collections.sort(keys);

        for (int i = keys.size()-1; i >= 0; i--) {
            int div = A / keys.get(i);

            if (div != 0) {
                for (int j = 1; j <= div; j++) {
                    sb.append(values.get(keys.get(i)));
                }

                A = A - (div*keys.get(i));
            }
        }

        return sb.toString();
    }
}
