public class Solution {
    public String getHint(String secret, String guess) {
        int countA = 0, countB = 0;
        int n = secret.length();
        int[] bulls = new int[10];
        int[] cows = new int[10];
        for(int i = 0; i < n; ++i) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls[secret.charAt(i) - '0'] += 1;
            } else {
                for(int j = 1; j < n; ++j) {
                    if(secret.charAt((i + j) % n) == guess.charAt(i)) cows[guess.charAt(i) - '0'] = 1;
                }
            }
        }
        for(int i = 0; i < 10; ++i) {
            countA += bulls[i];
            countB += cows[i];
        }
        return countA + "A" + countB + "B";
    }
}
