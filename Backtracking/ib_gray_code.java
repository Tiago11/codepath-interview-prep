public class Solution {
	public ArrayList<Integer> grayCode(int a) {
	    if (a == 0) {
	        ArrayList<Integer> code = new ArrayList<Integer>();
	        code.add(0);
	        return code;
	    }

	    ArrayList<Integer> code = grayCode(a-1);
	    int nextNum = (1 << (a-1));

	    for (int i = code.size()-1; i >= 0; i--) {
	        code.add(nextNum + code.get(i));
	    }

	    return code;
	}
}
