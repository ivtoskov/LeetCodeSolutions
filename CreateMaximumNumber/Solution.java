public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= k && i <= nums1.length; ++i) {
            int[] cand = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(cand, 0, result, 0)) result = cand;
        }
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int s1 = 0, s2 = 0, ind = 0; ind < k; ++ind) {
            res[ind] = (greater(nums1, s1, nums2, s2)) ? nums1[s1++] : nums2[s2++];
        }
        return res;
    }
    
    private boolean greater(int[] nums1, int s1, int[] nums2, int s2) {
        while (s1 < nums1.length && s2 < nums2.length && nums1[s1] == nums2[s2]) {
            ++s1;
            ++s2;
        }
        return s2 == nums2.length || (s1 < nums1.length && nums1[s1] > nums2[s2]);
    }
    
    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && nums[i] > res[j - 1]) --j;
            if (j < k) res[j++] = nums[i];
        }
        
        return res;
    }
}
