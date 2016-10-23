public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pcounts = new int[26], scounts = new int[26];
        for (char c : p.toCharArray()) {
            pcounts[c - 'a']++;
        }
        
        int diff = p.length();
        for (int i = 0; i < p.length(); ++i) {
            int ci = s.charAt(i) - 'a';
            if (++scounts[ci] <= pcounts[ci]) {
                --diff;
            }
        }
        
        if (diff == 0) {
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); ++i) {
            int ci = s.charAt(i) - 'a', pi = s.charAt(i - p.length()) - 'a';
            if (pcounts[pi] > 0 && --scounts[pi] < pcounts[pi]) {
                ++diff;
            }
            if (++scounts[ci] <= pcounts[ci]) {
                --diff;
            }
            if (diff == 0) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
}
