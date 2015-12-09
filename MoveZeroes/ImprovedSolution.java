public class ImprovedSolution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, zeroes = 0; i < nums.length; ++i) {
            if(nums[i] == 0) {
                ++zeroes;
            } else {
                nums[i - zeroes] = nums[i];
                if(zeroes >= 1) {
                    nums[i] = 0;
                }
            }
        }
    }
}
