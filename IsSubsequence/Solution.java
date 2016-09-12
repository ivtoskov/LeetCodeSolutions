public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int si = 0, ti = 0;
        while (ti < t.length()) {
            while (ti < t.length() && s.charAt(si) != t.charAt(ti)) {
                ++ti;
            }
            if (ti != t.length()) {
                ++si;
                ++ti;
                if (si == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
