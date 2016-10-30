public class Solution {
    public String originalDigits(String s) {
        int[] counts = new int[128], nums = new int[10];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        
        nums[0] = counts['z'];
        nums[2] = counts['w'];
        nums[4] = counts['u'];
        nums[6] = counts['x'];
        nums[8] = counts['g'];
        
        nums[1] = counts['o'] - nums[0] - nums[2] - nums[4];
        nums[3] = counts['h'] - nums[8];
        nums[5] = counts['f'] - nums[4];
        nums[7] = counts['s'] - nums[6];
        nums[9] = counts['i'] - nums[5] - nums[6] - nums[8];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            while (nums[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
