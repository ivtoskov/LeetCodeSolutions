public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> prev = new HashSet<>();
        int start = 0, best = 0;
        char[] chars = s.toCharArray();
        
        for (char c : chars) {
            while (prev.contains(c)) {
                prev.remove(chars[start++]);
            }
            prev.add(c);
            best = Math.max(best, prev.size());
        }
        
        return best;
    }
}
