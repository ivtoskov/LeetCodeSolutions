public class Solution {
    public String getHint(String secret, String guess) {
        int[] digits = new int[11];
        char[] gChars = guess.toCharArray();
        int a = 0, b = 0;
        
        for(int i = 0; i < secret.length(); ++i) {
            if(gChars[i] == secret.charAt(i)) {
                ++a;
                gChars[i] = '0' + 10;
            } else {
                digits[secret.charAt(i) - '0']++;
            }
        }
        
        for(int i = 0; i < guess.length(); ++i) {
            if(digits[gChars[i] - '0']-- > 0) {
                ++b;
            }
        }
        return a + "A" + b + "B";
    }
}
