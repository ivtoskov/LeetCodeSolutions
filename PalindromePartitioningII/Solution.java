public class Solution {
    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] cut = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            cut[i] = i - 1;
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; i - j >= 0 && i + j < n && chars[i - j] == chars[i + j]; ++j) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j] + 1);
            }
            
            for (int j = 1; i - j + 1 >= 0 && i + j < n && chars[i - j + 1] == chars[i + j]; ++j) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j + 1] + 1);
            }
        }
        
        return cut[n];
    }
}
