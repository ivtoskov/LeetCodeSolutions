public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i <= n; ++i) {
            int root = (int) Math.sqrt(i);
            
            if(root * root == i) {
                dp[i] = 1;
                continue;
            }
            
            for(int j = 1; j <= root; ++j) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}
