public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {

        String[] arr = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = Integer.toString(A[i]);
            //System.out.print(arr[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                StringBuilder sb1 = new StringBuilder(s1);
                sb1.append(s2);
                String s1s2 = sb1.toString();

                StringBuilder sb2 = new StringBuilder(s2);
                sb2.append(s1);
                String s2s1 = sb2.toString();

                long fs = Long.parseLong(s1s2);
                long sf = Long.parseLong(s2s1);

                if (fs > sf) {
                    return 1;
                } else if (fs < sf) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        /*
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
        */
        StringBuilder sb = new StringBuilder("");
        for (int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        //System.out.println(arr[arr.length-1]);
        if ("0".equals(arr[arr.length-1]) && arr.length > 1) {
            return new String("0");
        }

        return sb.toString();

    }
}
