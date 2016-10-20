public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; ) {
            int s = i + 1, e = n - 1;
            while (s < e) {
                int currentSum = nums[i] + nums[s] + nums[e];
                if (currentSum == target) {
                    return currentSum;
                }
                if (Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }
                if (currentSum <= target) {
                    ++s;
                } else {
                    --e;
                }
            }
            i = increment(nums, i, n - 2);
        }
        
        return result;
    }
    
    private int increment(int[] nums, int index, int end) {
        int current = nums[index];
        while (index < end && nums[index] == current) {
            index++;
        }
        return index;
    }
}
