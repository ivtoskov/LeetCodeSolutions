public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; ) {
            int s = i + 1, e = n - 1;
            while (s < e) {
                if (nums[i] + nums[s] + nums[e] == 0) {
                    int cur = nums[s];
                    result.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    s = increment(nums, s, e);
                } else if (nums[i] + nums[s] + nums[e] < 0) {
                    ++s;
                } else {
                    --e;
                }
            }
            i = increment(nums, i, n - 2);
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
