public class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int['z' - 'A' + 1];
        int mid = 0, total = 0, mask = ~1;
        for (char c : s.toCharArray()) {
            counts[c - 'A']++;
        }
        
        for (int count : counts) {
            if ((count & 1) != 0) {
                mid = 1;
            }
            
            total += (count & mask);
        }
        
        return total + mid;
    }
}
