public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickselect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }
        int pivot = nums[end], left = start, right = end - 1;
        
        while (left <= right) {
            if (nums[left] > pivot) {
                swap(nums, left, right);
                --right;
            } else {
                ++left;
            }
        }
        swap(nums, left, end);
        
        if (left == k) {
            return nums[left];
        }
        if (left < k) {
            return quickselect(nums, left, end, k);
        } else {
            return quickselect(nums, start, left - 1, k);
        }
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
