public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        java.util.Map<Character, Integer> charCounts = new java.util.HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            Integer current = charCounts.get(s.charAt(i));
            if(current == null) current = 0;
            charCounts.put(s.charAt(i), current + 1);
            
            current = charCounts.get(t.charAt(i));
            if(current == null) current = 0;
            charCounts.put(t.charAt(i), current - 1);
        }
        for(Integer i: charCounts.values()) {
            if(i != 0) return false;
        }
        return true;
    }
}
