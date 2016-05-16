public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, k = 2, count = 0;
        if(nums.length <= k) {
            return nums.length;
        }
        
        for(int j = 1; j < nums.length; ++j) {
            if(nums[i] == nums[j]) {
                if(++count < k) {
                    nums[++i] = nums[j];
                }
            } else {
                nums[++i] = nums[j];
                count = 0;
            }
        }
        return i + 1;
    }
}
