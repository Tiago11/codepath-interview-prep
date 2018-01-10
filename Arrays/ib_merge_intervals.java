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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        // Check if Interval is in the right form.
        if (newInterval.start > newInterval.end) {
            int tmp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = tmp;
        }

        // Check if there is any interval in the list.
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        // Check if newInterval should go at the beginning
        if (intervals.get(0).start > newInterval.start && intervals.get(0).start > newInterval.end) {
            intervals.add(0, newInterval);
            return intervals;
        }

        // Check if newInterval should go at the end.
        if (intervals.get(intervals.size()-1).end < newInterval.start) {
            intervals.add(newInterval);
            return intervals;
        }

        // Check if newInterval 'eats' all the intervals.
        if (intervals.get(0).start > newInterval.start &&
                intervals.get(intervals.size()-1).end < newInterval.end) {
            ArrayList<Interval> res = new ArrayList<Interval>();
            res.add(newInterval);
            return res;
        }

        // Check if newInterval goes somewhere in the middle.
        int k = 0;
        while (k < intervals.size() && intervals.get(k).end < newInterval.start) {
            k++;
        }

        if (intervals.get(k).start > newInterval.end) {
            intervals.add(k, newInterval);
            return intervals;
        }

        // Check for overlapping intervals with newInterval.
        int startOverlap = -1;
        int endOverlap = -1;

        for (int i = 0; i < intervals.size(); i++) {
            if (Math.max(intervals.get(i).start, newInterval.start) <= Math.min(intervals.get(i).end, newInterval.end)) {
                if (startOverlap == -1) {
                    startOverlap = i;
                }
                endOverlap = i;
            }
        }

        Interval mergedInterval = new Interval(Math.min(intervals.get(startOverlap).start, newInterval.start), Math.max(intervals.get(endOverlap).end, newInterval.end));

        // Remove the overlapping intervals.
        for (int i = startOverlap; i <= endOverlap; i++) {
            intervals.remove(startOverlap);
        }

        intervals.add(startOverlap, mergedInterval);

        return intervals;
    }
}
