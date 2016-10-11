public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 0, index = -1;
        int[] count = new int[n], prev = new int[n];
        Arrays.sort(nums);
        
        for (int i = 0; i < n; ++i) {
            count[i] = 1;
            prev[i] = -1;
            
            for (int j = i - 1; j >= 0; --j) {
                if ((nums[i] % nums[j]) == 0) {
                    if (count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        
        List<Integer> result = new ArrayList<>(max);
        while (index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }
        return result;
    }
}
