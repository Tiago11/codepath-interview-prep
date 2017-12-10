public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {

	    if(numerator == 0) {
            return "0";
	    }

        if(denominator == 0) {
            return "";
        }

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder result = new StringBuilder("");

        if ((numerator < 0) && (denominator > 0) || (numerator > 0) && (denominator < 0)) {
            result.append("-");
        }

        long n = numerator;
        long de = denominator;
        n = Math.abs(n);
        de = Math.abs(de);

        long res = n/de;
        result.append(String.valueOf(res));

        long remainder = (n % de);
        if(remainder == 0) {
            return result.toString();
        }

        result.append(".");

        while(remainder != 0 && !map.containsKey(remainder)){
            map.put(remainder, result.length());
            remainder = remainder * 10;
            res = remainder/de;
            result.append(String.valueOf(res));
            remainder = (remainder % de);
        }

        if (remainder == 0) {
            return result.toString();
        } else {
            int beg = map.get(remainder);
            String part1 = result.substring(0, beg);
            String part2 = result.substring(beg, result.length());
            result.setLength(result.length() - part2.length());
            result.append("(");
            result.append(part2);
            result.append(")");
            return result.toString();
        }
	}
}
