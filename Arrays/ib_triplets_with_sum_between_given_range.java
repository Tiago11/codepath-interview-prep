public class Solution {
    public int solve(ArrayList<String> A) {

        double[] arr = new double[A.size()];
        for (int i = 0; i < A.size(); i++) {
            arr[i] = Double.parseDouble(A.get(i));
        }

        ArrayList<Double> bucketA = new ArrayList<Double>();
        ArrayList<Double> bucketB = new ArrayList<Double>();
        ArrayList<Double> bucketC = new ArrayList<Double>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 2.0/3.0) {
                bucketA.add(arr[i]);
            } else if (arr[i] >= 2.0/3.0 && arr[i] <= 1.0) {
                bucketB.add(arr[i]);
            } else if (arr[i] > 1.0 && arr[i] < 2.0) {
                bucketC.add(arr[i]);
            }
        }

        Collections.sort(bucketA);
        Collections.sort(bucketB);
        Collections.sort(bucketC);

        double sum;

        if (bucketA.size() >= 3) {
            sum = bucketA.get(bucketA.size()-1) + bucketA.get(bucketA.size()-2) + bucketA.get(bucketA.size()-3);
            if (sum > 1.0) {
                return 1;
            }
        }

        if (bucketA.size() >= 2 && bucketB.size() >= 1) {
            sum = bucketA.get(bucketA.size()-1) + bucketA.get(bucketA.size()-2);

            for (int i = 0; i < bucketB.size(); i++) {
                if (sum + bucketB.get(i) > 1.0 && sum + bucketB.get(i) < 2.0) {
                    return 1;
                }
            }
        }

        if (bucketA.size() >= 2 && bucketC.size() >= 1) {
            sum = bucketA.get(0) + bucketA.get(1) + bucketC.get(0);

            if (sum < 2.0) {
                return 1;
            }
        }

        if (bucketA.size() >= 1 && bucketB.size() >= 2) {
            sum = bucketB.get(0) + bucketB.get(1);

            for (int i = 0; i < bucketA.size(); i++) {
                if (sum + bucketA.get(i) > 1.0 && sum + bucketA.get(i) < 2.0) {
                    return 1;
                }
            }
        }

        if (bucketA.size() >= 1 && bucketB.size() >= 1 && bucketC.size() >= 1) {
            sum = bucketA.get(0) + bucketB.get(0) + bucketC.get(0);

            if (sum < 2.0) {
                return 1;
            }
        }

        return 0;
    }
}
