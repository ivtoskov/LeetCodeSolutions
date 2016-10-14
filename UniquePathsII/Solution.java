public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null ||
            obstacleGrid.length < 1 ||
            obstacleGrid[0].length < 1 ||
            obstacleGrid[0][0] == 1 ||
            obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        
        for (int i = 1; i < n; ++i) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
        }
        for (int i = 1; i < m; ++i) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 1) ? 0 : obstacleGrid[0][i - 1];
        }
        
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                obstacleGrid[i][j] = (obstacleGrid[i][j] == 1) ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        
        return obstacleGrid[n - 1][m - 1];
    }
}
