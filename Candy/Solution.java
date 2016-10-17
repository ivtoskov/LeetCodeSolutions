public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n], right = new int[n];
        left[0] = right[n - 1] = 1;
        for (int i = 1, j = n - 2; i < n; ++i, --j) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
            
            if (ratings[j] > ratings[j + 1]) {
                right[j] = right[j + 1] + 1;
            } else {
                right[j] = 1;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
