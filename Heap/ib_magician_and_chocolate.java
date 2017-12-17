public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(B.size(), Collections.reverseOrder());
        for (Integer x : B) {
            pq.add(x);
        }

        int count = 0;
        int totalChocolates = 0;
        while (count < A) {
            int chocolates = pq.poll();
            totalChocolates = ((totalChocolates % 1000000007) + (chocolates % 1000000007)) % 1000000007;

            pq.add((int)Math.floor(chocolates/2));

            count++;
        }

        return (totalChocolates % 1000000007);
    }
}
