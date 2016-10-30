public class Solution {
    private int m, n;
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        m = matrix.length;
        if (m <= 0) {
            return result;
        }
        n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; ++i) {
            dfs(matrix, i, 0, pacific);
            dfs(matrix, i, n - 1, atlantic);
        }
        
        for (int i = 0; i < n; ++i) {
            dfs(matrix, 0, i, pacific);
            dfs(matrix, m - 1, i, atlantic);
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        
        return result;
    }
    
    private int[][] directions = {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
    };
    
    private void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] dir : directions) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newJ >= 0 && newI < m && newJ < n && !visited[newI][newJ] && matrix[newI][newJ] >= matrix[i][j]) {
                dfs(matrix, newI, newJ, visited);
            }
        }
    }
}
