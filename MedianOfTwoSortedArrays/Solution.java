public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        
        if (len2 < len1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        if (len1 == 0) {
            return (nums2[(len2 - 1) / 2] + nums2[len2 / 2]) / 2.0;
        }
        
        int low = 0, high = len1 * 2;
        
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = len1 + len2 - mid1;
            
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double R2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            
            if (L2 > R1) {
                low = mid1 + 1;
            } else if (L1 > R2) {
                high = mid1 - 1;
            } else {
                return (Math.min(R1, R2) + Math.max(L1, L2)) / 2.0;
            }
        }
        
        return -1;
    }
}
