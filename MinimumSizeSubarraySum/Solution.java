public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        
        for (int end = 0, start = 0, sum = 0; end < nums.length; ++end) {
            sum += nums[end];
            
            while (sum >= s) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
