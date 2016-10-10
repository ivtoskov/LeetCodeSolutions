public class Solution {
    public int superPow(int a, int[] b) {
        int[] pows = initAPowers(a);
        
        int prev = 1;
        for (int cur : b) {
            prev = (toTheTenth(prev) * pows[cur]) % 1337;
        }
        return prev;
    }
    
    private int[] initAPowers(long a) {
        int[] pows = new int[10];
        pows[0] = 1;
        for (int i = 1; i < 10; ++i) {
            pows[i] = (int) ((pows[i - 1] * a) % 1337);
        }
        return pows;
    }
    
    private int toTheTenth(int a) {
        a %= 1337;
        int res = 1;
        for (int i = 0; i < 10; ++i) {
            res = (res * a) % 1337;
        }
        return res;
    }
}
