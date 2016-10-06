public class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                updateCell(i, j, board);
            }
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private void updateCell(int i, int j, int[][] board) {
        int alive = -(board[i][j] & 1);
        for (int k = Math.max(i - 1, 0); k <= Math.min(i + 1, board.length - 1); ++k) {
            for (int p = Math.max(j - 1, 0); p <= Math.min(j + 1, board[i].length - 1); ++p) {
                alive += (board[k][p] & 1);
            }
        }
        
        if (alive == 3 || (board[i][j] == 1 && alive == 2)) {
            board[i][j] |= 2;
        }
    }
}
