public class Solution {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        for (char c: t.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c: s.toCharArray()) {
            chars[c - 'a']--;
        }
        char diffChar = 'a';
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] > 0) {
                diffChar = (char) (i + 'a');
                break;
            }
        }
        return diffChar;
    }
}
