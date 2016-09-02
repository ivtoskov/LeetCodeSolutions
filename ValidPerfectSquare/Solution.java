public class Solution {
    public boolean isPerfectSquare(int num) {
        double x = num;
        
        while (true) {
            double prev = x;
            x = x - (x * x - num) / (2 * x);
            if (Math.abs(x - prev) < 0.1) {
                break;
            }
        }
        
        int res = (int) x;
        return res * res == num;
    }
}
