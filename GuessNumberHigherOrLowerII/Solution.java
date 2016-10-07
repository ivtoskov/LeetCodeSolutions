public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int offset = 1; offset < n; ++offset) {
            for (int i = 1; i + offset <= n; ++i) {
                int j = i + offset;
                int min = Integer.MAX_VALUE;
                
                for (int k = i; k < j; ++k) {
                    int current = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    min = Math.min(min, current);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}
