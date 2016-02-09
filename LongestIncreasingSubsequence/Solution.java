public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length, len = 1;
        int[] prev = new int[n];
        prev[0] = nums[0];
        for(int i = 1; i < n; ++i) {
            if(nums[i] > prev[len - 1]) {
                prev[len++] = nums[i];
            } else {
                int pivot = binarySearch(prev, 0, len - 1, nums[i]);
                prev[pivot] = nums[i];
            }
        }
        
        return len;
    }
    
    private int binarySearch(int[] nums, int left, int right, int key) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == key) {
                return mid;
            } else if(nums[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
