public class Solution {
    public int strStr(String haystack, String needle) {
        int hlength = haystack.length();
        int nlength = needle.length();
        for(int i = 0; i <= hlength - nlength; ++i) {
            String sub = haystack.substring(i, i + nlength);
            if(needle.equals(sub)) {
                return i;
            }
        }
        return -1;
    }
}
