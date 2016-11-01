public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        java.util.NavigableSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; ++i) {
            Integer floorElement = set.floor(nums[i]), ceilingElement = set.ceiling(nums[i]);
            if ((floorElement != null && (long) nums[i] - floorElement <= t) ||
                (ceilingElement != null && (long) ceilingElement - nums[i] <= t)) {
                    return true;
                }
            
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}
