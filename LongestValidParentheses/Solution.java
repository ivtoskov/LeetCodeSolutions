public class Solution {
    public int longestValidParentheses(String s) {
        return Math.max(helper(s, '('), helper(new StringBuilder(s).reverse().toString(), ')'));
    }
    
    private int helper(String s, char open) {
        int cnt = 0, bestlen = 0, len = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == open) {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt < 0) {
                cnt = len = 0;
            } else {
                len++;
                if (cnt == 0) {
                    bestlen = Math.max(bestlen, len);
                }
            }
        }
        return bestlen;
    }
}
