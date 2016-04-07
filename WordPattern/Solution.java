public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        if(pattern.length() != words.length) {
            return false;
        }
        for(int i = 0; i < pattern.length(); ++i) {
            if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(words[i])) 
                map.put(pattern.charAt(i), words[i]);
            else
                if(!map.containsKey(pattern.charAt(i)) || !map.get(pattern.charAt(i)).equals(words[i])) return false;
        }
        return true;
    }
}
