public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {left(nums, target), right(nums, target)};    
    }
    
    private int left(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return (right >= 0 && nums[right] == target) ? right : -1;
    }
    
    private int right(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        
        return (left < nums.length && nums[left] == target) ? left : -1;
    }
}
