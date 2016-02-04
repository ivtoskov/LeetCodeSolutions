public class NumArray {
    private int[] sums;
    private int[] nums;
    public NumArray(int[] nums) {
        if(nums != null && nums.length != 0) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for(int i = 1; i < nums.length; ++i) {
                sums[i] = nums[i] + sums[i - 1];
            }
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        return sums[j] - sums[i] + nums[i];
    }
}
