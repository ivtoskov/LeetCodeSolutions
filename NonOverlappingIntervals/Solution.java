public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        Interval active = intervals[0];
        int result = 0;
        
        for (int i = 1; i < intervals.length; ++i) {
            Interval current = intervals[i];
            if (active.end > current.start) {
                ++result;
                active = (active.end < current.end) ? active : current;
            } else {
                active = current;
            }
        }
        
        return result;
    }
}
