public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] lens = new int[A.length];
        for (int i = 2; i < A.length; ++i) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                lens[i] = Math.max(1, lens[i - 1] + 1);
            }
        }
        return Arrays.stream(lens).sum();
    }
}
