public class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        char[] comb = (s + '#' + rev).toCharArray();
        int[] table = new int[comb.length];
        for (int i = 1; i < table.length; ++i) {
            int j = table[i - 1];
            while (j > 0 && comb[i] != comb[j]) {
                j = table[j - 1];
            }
            if (comb[i] == comb[j]) {
                ++j;
            }
            table[i] = j;
        }
        return new StringBuilder(rev.substring(0, rev.length() - table[table.length - 1])) + s;
    }
}
