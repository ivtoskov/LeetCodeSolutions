public class Solution {
    int left = 0, right = 0;
    
    public String longestPalindrome(String s) {
        if (s.length() < 1) {
            return s;
        }
        longestPalindrome(s, 0, 0);
        for (int i = 1; i < s.length(); ++i) {
            longestPalindrome(s, i - 1, i);
            longestPalindrome(s, i, i);
        }
        return s.substring(left, right);
    }
    
    private void longestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        ++l;
        
        if (r - l > right - left) {
            left = l;
            right = r;
        }
    }
}
