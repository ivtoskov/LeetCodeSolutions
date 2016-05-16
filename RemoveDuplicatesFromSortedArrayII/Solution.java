public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) {
            return nums.length;
        }
        int result = nums.length, prev = nums[0];
        boolean twice = false;
        for(int pos = 1, index = 1; pos < nums.length && index < nums.length; ++pos, ++index) {
            if(nums[index] == prev) {
                if(twice) {
                    while(index < nums.length && nums[index] == prev) {
                        --result;
                        ++index;
                    }
                    twice = false;
                } else {
                    twice = true;
                }
            } else {
                twice = false;
            }
            if(index < nums.length) {
                nums[pos] = nums[index];
                prev = nums[index];
            }
        }
        return result;
    }
}
