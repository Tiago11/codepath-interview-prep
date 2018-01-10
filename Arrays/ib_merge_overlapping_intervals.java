/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Collections.sort(intervals, IntervalComparator);

        int i = 0;
        while (i < intervals.size()-1) {
            Interval intOne = intervals.get(i);
            Interval intTwo = intervals.get(i+1);
            if (Math.max(intOne.start, intTwo.start) <= Math.min(intOne.end, intTwo.end)) {
                Interval mergedInterval = new Interval(Math.min(intOne.start, intTwo.start),
                                                        Math.max(intOne.end, intTwo.end));

                intervals.remove(i);
                intervals.remove(i);

                intervals.add(i, mergedInterval);
            } else {
                i++;
            }
        }

        return intervals;
    }

    public static Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
            Integer start1 = i1.start;
            Integer start2 = i2.start;

            return start1.compareTo(start2);
        }
    };
}
