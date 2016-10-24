public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combSum(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    
    private void combSum(int[] nums, int index, int rem, List<Integer> buffer, List<List<Integer>> result) {
        if (rem == 0) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        
        for (int i = index; i < nums.length; ++i) {
            if (rem - nums[i] >= 0) {
				if (i > index && nums[i] == nums[i - 1]) {
					continue;
				}
                buffer.add(nums[i]);
                combSum(nums, i + 1, rem - nums[i], buffer, result);
                buffer.remove(buffer.size() - 1);
            } else {
                break;
            }
        }
    }
}
