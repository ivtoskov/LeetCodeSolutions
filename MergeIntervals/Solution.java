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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, (Interval i1, Interval i2) -> i1.start - i2.start);
        Integer start = intervals.get(0).start, end = intervals.get(0).end;
        for (Interval current : intervals) {
            if (end < current.start) {
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            } else {
                end = Math.max(end, current.end);
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
