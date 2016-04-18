public class Solution {
    public int lengthOfLastWord(String s) {
        int answer = 0;
        int index = s.length() - 1;
        while(index >= 0 && s.charAt(index) == ' ') --index;
        while(index >= 0) {
            if(s.charAt(index--) == ' ') {
                break;
            }
            ++answer;
        }
        return answer;
    }
}
