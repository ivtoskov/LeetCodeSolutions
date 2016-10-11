public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] buffer = new int[triangle.size()];
        buffer[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); ++i) {
            List<Integer> level = triangle.get(i);
            buffer[i] = level.get(i) + buffer[i - 1];
            for (int j = i - 1; j >= 1; --j) {
                buffer[j] = level.get(j) + Math.min(buffer[j], buffer[j-1]);
            }
            buffer[0] = level.get(0) + buffer[0];
        }
        return Arrays.stream(buffer).min().orElse(0);
    }
}
