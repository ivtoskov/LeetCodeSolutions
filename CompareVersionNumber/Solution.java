public class Solution {
    public int compareVersion(String version1, String version2) {
        for(int i = 0, j = 0, v1score = 0, v2score = 0; i < version1.length() || j < version2.length(); ++i, ++j, v1score = 0, v2score = 0) {
            while(i < version1.length() && version1.charAt(i) != '.') {
                v1score = v1score * 10 + version1.charAt(i) - '0';
                ++i;
            }
            while(j < version2.length() && version2.charAt(j) != '.') {
                v2score = v2score * 10 + version2.charAt(j) - '0';
                ++j;
            }
            if(v1score > v2score) {
                return 1;
            }
            if(v1score < v2score) {
                return -1;
            }
        }
        return 0;
    }
}
