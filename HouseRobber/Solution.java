public class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        for(int i = 0; i < cache.length; ++i) {
            cache[i] = -1;
        }
        return rob(nums, 0, cache);
    }
    
    public int rob(int[] nums, int index, int[] cache) {
        if(index >= nums.length) {
            return 0;
        }
        if(cache[index] >= 0) {
            return cache[index];
        }
        int sol1 = rob(nums, index + 1, cache);
        int sol2 = nums[index] + rob(nums, index + 2, cache);
        cache[index] = Math.max(sol1, sol2);
        return cache[index];
    }
}
