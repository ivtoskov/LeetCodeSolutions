public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prev = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            if(prev.containsKey(target-nums[i])) {
                return new int[]{prev.get(target-nums[i]), i};
            }
            prev.put(nums[i], i);
        }
        return null;
    }
}
