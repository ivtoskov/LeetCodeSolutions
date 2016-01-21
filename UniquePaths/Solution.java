public class Solution {
    public int uniquePaths(int m, int n) {
        double result = 1, min = Math.min(m, n), max = Math.max(m, n);
        for(int i = 1; i < min; ++i) {
            result = (result * (min + max - 1 - i)) / i;
        }
        return (int) result;
    }
}
