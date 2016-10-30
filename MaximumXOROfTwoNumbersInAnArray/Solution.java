public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        
        for (int i = 30; i >= 0; --i) {
            mask |= 1 << i;
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            
            int tmp = max | (1 << i);
            for (int prefix : prefixes) {
                if (prefixes.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        
        return max;
    }
}
