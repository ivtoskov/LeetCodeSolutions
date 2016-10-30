public class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0, counts[] = new int[256];
        for (int start = 0, end = 0, max = 0; end < s.length(); ++end) {
            max = Math.max(max, ++counts[s.charAt(end)]);
            if (end - start + 1 - max > k) --counts[s.charAt(start++)];
            result = end - start + 1;
        }
        return result;
    }
}
