public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        dungeon[n - 1][m - 1] = Math.max(1, 1 - dungeon[n - 1][m - 1]);
        
        for (int i = n - 2; i >= 0; --i) {
            dungeon[i][m - 1] = Math.max(1, dungeon[i + 1][m - 1] - dungeon[i][m - 1]);
        }
        
        for (int i = m - 2; i >= 0; --i) {
            dungeon[n - 1][i] = Math.max(1, dungeon[n - 1][i + 1] - dungeon[n - 1][i]);
        }
        
        for (int i = n - 2; i >= 0; --i) {
            for (int j = m - 2; j >= 0; --j) {
                dungeon[i][j] = Math.max(1, Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j]);
            }
        }
        
        return dungeon[0][0];
    }
}
