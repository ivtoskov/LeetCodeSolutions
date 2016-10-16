public class Solution {
    public String minWindow(String s, String t) {
        int[] counts = new int[128];
        for (char c : t.toCharArray()) {
            counts[c]++;
        }
        
        int start = 0, end = 0, bestStart = 0, bestEnd = s.length() + 1, count = t.length();
        while (end < s.length()) {
            if (counts[s.charAt(end++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (bestEnd - bestStart > end - start) {
                    bestStart = start;
                    bestEnd = end;
                }
                if (counts[s.charAt(start++)]++ == 0) {
                    count++;
                }
            }
        }
        
        return bestEnd != s.length() + 1 ? s.substring(bestStart, bestEnd) : "";
    }
}
