public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1unique = new HashSet<>();
        for(int num: nums1) {
            nums1unique.add(num);
        }
        Set<Integer> resSet = new HashSet<>();
        for(int num: nums2) {
            if(nums1unique.contains(num)) {
                resSet.add(num);
            }
        }
        int[] res = new int[resSet.size()];
        int index = 0;
        for(int num: resSet) {
            res[index++] = num;
        }
        return res;
    }
}
