public class Solution {
    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][];
        for (int i = 0; i < board.length; ++i) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                board[i][j] = updateCell(i, j, board, copy);
            }
        }
    }
    
    private int updateCell(int i, int j, int[][] board, int[][] copy) {
        int alive = 0;
        for (int k = i - 1; k <= i + 1; ++k) {
            for (int p = j - 1; p <= j + 1; ++p) {
                if (isOutOfBounds(k, p, board) || (k == i && p == j)) {
                    continue;
                }
                
                alive += copy[k][p];
            }
        }
        
        if (alive == 3 || (board[i][j] == 1 && alive == 2)) {
            return 1;
        }
        return 0;
    }
    
    private boolean isOutOfBounds(int k, int p, int[][] board) {
        return k < 0 || k >= board.length ||
               p < 0 || p >= board[0].length;
    }
}
