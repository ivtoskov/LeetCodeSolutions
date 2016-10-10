public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int start, int end) {
        if(nums == null) return 0;
        
        int taken = 0, notTaken = 0, temp = 0;
        for(int i = start; i <= end; ++i) {
            temp = taken;
            taken = notTaken + nums[i];
            notTaken = Math.max(temp, notTaken);
        }
        
        return Math.max(taken, notTaken);
    }
}
