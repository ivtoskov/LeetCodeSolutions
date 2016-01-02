public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); ++i) {
            for(String s: strs) {
                if(i >= s.length() || strs[0].charAt(i) != s.charAt(i)) return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
