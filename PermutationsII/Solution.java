public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        
        return result;
    }
    
    private void helper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            result.add(perm);
            return;
        }
        
        Set<Integer> vis = new HashSet<>();
        for (int i = index; i < nums.length; ++i) {
            if (vis.add(nums[i])) {
                swap(nums, i, index);
                helper(nums, index + 1, result);
                swap(nums, i, index);
            }
        }
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
