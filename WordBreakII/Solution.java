public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (!isBreakable(s, wordDict)) {
            return new ArrayList<>();
        }
        int n = s.length();
        List<String>[] dp = new List[n];
        
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = new ArrayList<>();
            for (int j = i + 1; j < n; ++j) {
                if (!dp[j].isEmpty()) {
                    String current = s.substring(i, j);
                    if (wordDict.contains(current)) {
                        for (String prev : dp[j]) {
                            dp[i].add(current + ' ' + prev);
                        }
                    }
                }
            }
            String whole = s.substring(i, n);
            if (wordDict.contains(whole)) {
                dp[i].add(whole);
            }
        }
        
        return dp[0];
    }
    
    private boolean isBreakable(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[s.length() + 1];
        dp[n] = true;
        
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j <= n; ++j) {
                if (dp[j] && wordDict.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[0];
    }
}
