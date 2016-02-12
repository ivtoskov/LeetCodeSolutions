public class Solution {
    public String getHint(String secret, String guess) {
        int[] sDigits = new int[10];
        int[] gDigits = new int[10];
        int bulls = 0, cows = 0;
        for(int i = 0; i < secret.length(); ++i) {
            if(secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                sDigits[secret.charAt(i) - '0']++;
                gDigits[guess.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < 10; ++i) {
            cows += Math.min(sDigits[i], gDigits[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
