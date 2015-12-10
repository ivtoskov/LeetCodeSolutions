public class Solution {
    public int titleToNumber(String s) {
        int answer = 0;
        for(int i = s.length() - 1, factor = 1; i >=0; --i, factor *= 26) {
            answer += (s.charAt(i) - 'A' + 1) * factor;
        }
        return answer;
    }
}
