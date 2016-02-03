public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int level = 0; level < n / 2; ++level) {
            for(int i = level; i < n - level - 1; ++i) { // level = 0, i = 0
                int temp = matrix[level][i], back = n - 1; // temp = 1
                matrix[level][i] = matrix[back - i][level]; // matrix[0][0] = matrix[1][0] (3)
                matrix[back - i][level] = matrix[back - level][back - i]; // matrix[1][0] = matrix[1][1] (4)
                matrix[back - level][back - i] = matrix[i][back - level]; // matrix[1][1] = matrix[0][1] (2)
                matrix[i][back - level] = temp; // matrix[0][1] = 1
            }
        }
    }
}
