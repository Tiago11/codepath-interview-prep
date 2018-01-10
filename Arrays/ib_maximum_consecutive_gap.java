public class Solution {

    // Auxiliary class representing a bucket.
    class Bucket {
        int low;
        int high;

        public Bucket() {
            low = -1;
            high = -1;
        }
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {

        if (A.size() < 2) {
            return 0;
        }

        // Find max and min.
        int max = A.get(0);
        int min = A.get(0);

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
            if (A.get(i) < min) {
                min = A.get(i);
            }
        }

        // Create the buckets array.
        Bucket[] buckets = new Bucket[A.size()];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        // Find the length or capacity of a bucket.
        int bucketLength = (int) Math.ceil(((double)max - min)/ (A.size()-1));

        // If bucketLength is zero, all the values in the array are repeated.
        if (bucketLength == 0) {
            return 0;
        }

        for (int i = 0; i < A.size(); i++) {
            // We find the index of the bucket for this specific value.
            int index = (A.get(i) - min) / bucketLength;

            if (buckets[index].low == -1) {
                buckets[index].low = A.get(i);
                buckets[index].high = A.get(i);
            } else {
                buckets[index].low = Math.min(buckets[index].low, A.get(i));
                buckets[index].high = Math.max(buckets[index].high, A.get(i));
            }
        }

        // Now that we have the values into buckets, we compare the gaps
        // between values of different buckets, that's where the maxGap will be.
        int maxGap = 0;
        int prev = buckets[0].high;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].low != -1) {
                maxGap = Math.max(maxGap, buckets[i].low - prev);
                prev = buckets[i].high;
            }
        }

        return maxGap;
    }
}
