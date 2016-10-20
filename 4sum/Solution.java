public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        for (int j = 0; j < n - 3; ) {
            for (int i = j + 1; i < n - 2; ) {
                int s = i + 1, e = n - 1;
                while (s < e) {
                    if (nums[j] + nums[i] + nums[s] + nums[e] == target) {
                        result.add(Arrays.asList(nums[j], nums[i], nums[s], nums[e]));
                        s = increment(nums, s, e);
                    } else if (nums[j] + nums[i] + nums[s] + nums[e] < target) {
                        ++s;
                    } else {
                        --e;
                    }
                }
                i = increment(nums, i, n - 2);
            }
            j = increment(nums, j, n - 3);
        }
        
        return result;
    }
    
    private int increment(int[] nums, int index, int end) {
        int current = nums[index];
        while (index < end && nums[index] == current) {
            index++;
        }
        return index;
    }
}
