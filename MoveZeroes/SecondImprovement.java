public class SecondImprovement {
    public void moveZeroes(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) nums[n++] = nums[i];
        }
        Arrays.fill(nums, n, nums.length, 0);
    }
}
