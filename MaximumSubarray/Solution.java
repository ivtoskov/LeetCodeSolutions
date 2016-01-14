public class Solution {
    public int maxSubArray(int[] nums) {
        int best = 0, current = 0, m = Integer.MIN_VALUE;
        for(int n: nums) {
            if(current + n > 0) {
                current += n;
                if(best < current) {
                    best = current;
                }
            } else {
                current = 0;
                if(n > m) {
                    m = n;
                }
            }
        }
        return (best > 0) ? best : m;
    }
}
