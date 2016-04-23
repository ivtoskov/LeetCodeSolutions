public class Solution {
    public String reverseString(String s) {
        int n = s.length();
        char[] revChars = new char[n];
        for(int i = 0; i < n; ++i) {
            revChars[i] = s.charAt(n - i - 1);
        }
        return new String(revChars);
    }
}
