public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 1) return false;
        java.util.Set<Integer> prev = new java.util.HashSet<>();
        for(int i: nums) {
            if(!prev.add(i)) return true;
        }
        return false;
    }
}
