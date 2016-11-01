public class Solution {
    public void nextPermutation(int[] nums) {
        int prev = Integer.MIN_VALUE, index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            --index;
        }
        
        if (index >= 0) {
            swap(nums, index, smallestBigger(nums, index));
        }
        
        reverse(nums, index + 1, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    
    private int smallestBigger(int[] nums, int index) {
        int pivot = nums[index], prev = index;
        for (int i = index + 1; i < nums.length; ++i) {
            if (nums[i] > pivot) {
                prev = i;
            } else {
                break;
            }
        }
        return prev;
    }
}
