public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return n;
        int prev1 = 1;
        int prev2 = 1;
        int current = 2;
        for(int i = 2; i <= n; ++i) {
            current = prev1 + prev2;
            prev1 = current - prev1;
            prev2 = current;
        }
        return current;
    }
}
