public class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    private boolean binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return true;
        }
        
        if (nums[start] < nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                return binarySearch(nums, start, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, end, target);
            }
        } else if (nums[start] > nums[mid]) {
            if (nums[mid] < target && nums[end] >= target) {
                return binarySearch(nums, mid + 1, end, target);
            } else {
                return binarySearch(nums, start, mid - 1, target);
            }
        } else {
            if (nums[mid] != nums[end]) {
                return binarySearch(nums, mid + 1, end, target);
            } else {
                boolean left = binarySearch(nums, start, mid - 1, target);
                return left || binarySearch(nums, mid + 1, end, target);
            }
        }
    }
}
