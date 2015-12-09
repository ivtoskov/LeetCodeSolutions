public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null) return;
        int j = 0, n = nums.length;
        while(j < n) {
            while(j < n && nums[j] != 0) ++j;
            if(j == n) break;
            int i = j + 1;
            while((i < n) && (nums[i] == 0)) ++i;
            if(i == n) break;
            nums[j++] = nums[i];
            nums[i] = 0;
        }
    }
}
