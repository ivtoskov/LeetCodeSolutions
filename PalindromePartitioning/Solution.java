public class Solution {
    private List<List<String>> empty = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        empty.add(new ArrayList<>());
        boolean[][] palTable = genPalTable(s.toCharArray());
        List<List<String>>[][] dp = new List[s.length()][s.length()];
        return partition(s, 0, s.length() - 1, dp, palTable);
    }
    
    private List<List<String>> partition(String s, int start, int end, List<List<String>>[][] dp, boolean[][] palTable) {
        if (start > end) {
            return empty;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        
        List<List<String>> result = new ArrayList<>();
        for (int i = start; i <= end; ++i) {
            if (palTable[start][i]) {
                String current = s.substring(start, i + 1);
                List<List<String>> prevLists = partition(s, i + 1, end, dp, palTable);
                for (List<String> prev : prevLists) {
                    List<String> currentList = new ArrayList<>();
                    currentList.add(current);
                    currentList.addAll(prev);
                    result.add(currentList);
                }
            }
        }
        
        dp[start][end] = result;
        return dp[start][end];
    }
    
    private boolean[][] genPalTable(char[] chars) {
        int n = chars.length;
        boolean[][] palTable = new boolean[n][n];
        palTable[0][0] = true;
        
        for (int i = 1; i < n; ++i) {
            palTable[i][i] = true;
            palTable[i - 1][i] = chars[i - 1] == chars[i];
        }
        
        for (int len = 3; len <= n; ++len) {
            for (int i = 0, j = len - 1; j < n; ++i, ++j) {
                palTable[i][j] = palTable[i + 1][j - 1] && chars[i] == chars[j];
            }
        }
        
        return palTable;
    }
}
