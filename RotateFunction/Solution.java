public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length, sum = 0, current = 0;
        for (int i = 0; i < n; ++i) {
            sum += A[i];
            current += i * A[i];
        }
        
        int max = current;
        for (int j = 1; j < n; ++j) {
            current = current - sum + n * A[j - 1];
            max = Math.max(max, current);
        }
        
        return max;
    }
}
