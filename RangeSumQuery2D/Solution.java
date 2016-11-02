public class NumMatrix {
    private final int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            matrix[i][0] += matrix[i - 1][0];
        }
        
        for (int i = 1; i < n; ++i) {
            matrix[0][i] += matrix[0][i - 1];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = matrix[row2][col2];
        if (row1 > 0) {
            result -= matrix[row1 - 1][col2];
        }
        if (col1 > 0) {
            result -= matrix[row2][col1 - 1];
        }
        
        if (row1 > 0 && col1 > 0) {
            result += matrix[row1 - 1][col1 - 1];
        }
        
        return result;
    }
}

