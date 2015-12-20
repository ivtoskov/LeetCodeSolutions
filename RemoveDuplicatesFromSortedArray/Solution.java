public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int index = 0;
        int current = nums[0] + 1;
        for(int i = 0; i < nums.length; ++i) {
            if(current != nums[i]) {
                current = nums[i];
                nums[index++] = current;
            }
        }
        return index;
    }
}
