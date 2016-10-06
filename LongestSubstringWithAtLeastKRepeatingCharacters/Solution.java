public class Solution {
    private int[] counts;
    private char[] chars;
    private int k;
    
    public int longestSubstring(String s, int k) {
        this.counts = new int[26];
        this.chars = s.toCharArray();
        this.k = k;
        return longestSubstring(0, s.length());
    }
    
    private int longestSubstring(int start, int end) {
        if ((end - start) < k) {
            return 0;
        }
        
        Arrays.fill(counts, 0);
        for (int i = start; i < end; ++i) {
            counts[chars[i] - 'a']++;
        }
        
        for (int i = start; i < end; ++i) {
            if (counts[chars[i] - 'a'] < k) {
                int left = longestSubstring(start, i);
                int right = longestSubstring(i + 1, end);
                return Math.max(left, right);
            }
        }
        
        return end - start;
    }
}
