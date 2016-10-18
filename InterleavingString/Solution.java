public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return (s1.length() + s2.length()) == s3.length() &&
               helper(s1, s2, s3, 0, 0, new int[s1.length() + 1][s2.length() + 1]) == 1;
    }
    
	private int helper(String s1, String s2, String s3, int i1, int i2, int[][] dp) {
		if (dp[i1][i2] != 0) {
			return dp[i1][i2];
		}

		if (i1 == s1.length() || i2 == s2.length()) {
			dp[i1][i2] = s1.substring(i1).equals(s3.substring(i1 + i2)) || s2.substring(i2).equals(s3.substring(i1 + i2)) ? 1 : -1;
		} else {
			char c1 = s1.charAt(i1), c2 = s2.charAt(i2), c3 = s3.charAt(i1 + i2);
			dp[i1][i2] = (c1 == c3 && helper(s1, s2, s3, i1 + 1, i2, dp) == 1) ||
					     (c2 == c3 && helper(s1, s2, s3, i1, i2 + 1, dp) == 1) ? 1 : -1;
		}

		return dp[i1][i2];
	}
}
