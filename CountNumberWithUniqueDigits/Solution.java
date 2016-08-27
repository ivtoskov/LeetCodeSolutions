public class Solution {
    private static int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
    public int countNumbersWithUniqueDigits(int n) {
        if(n > 10) {
            return countNumbersWithUniqueDigits(10);
        }
        if(n < 2) {
            return (int) Math.pow(10, n);
        }
    
        return 9 * 9 * factorials[8] / factorials[10 - n] + countNumbersWithUniqueDigits(n - 1);
    }
}
