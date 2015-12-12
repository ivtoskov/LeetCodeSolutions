public class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); ++i) {
            int summand = romanToInt(s.charAt(i));
            int next = (i+1 < s.length()) ? romanToInt(s.charAt(i + 1)) : 0;
            if(next > summand) {
                summand = next - summand;
                ++i;
            }
            answer += summand;
        }
        return answer;
    }
    
    private int romanToInt(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
}
