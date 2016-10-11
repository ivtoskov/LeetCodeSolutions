public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islands = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    islands++;
                    floodFill(grid, i, j);
                }
            }
        }
        return islands;
    }
    
    private void floodFill(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        floodFill(grid, i - 1, j);
        floodFill(grid, i + 1, j);
        floodFill(grid, i, j - 1);
        floodFill(grid, i, j + 1);
    }
}
