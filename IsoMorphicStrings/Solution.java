public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if(!map.containsKey(schar) && !map.containsValue(tchar)) map.put(schar, tchar);
            else if(!map.containsKey(schar) || map.get(schar) != tchar) {
                return false;
            }
        }
        return true;
    }
}
