public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; ++i) {
            int[] row = new int[10];
            int[] column = new int[10];
            for(int j = 0; j < 9; ++j) {
                if(board[i][j] != '.' && row[board[i][j] - '0']++ > 0) return false;
                if(board[j][i] != '.' && column[board[j][i] - '0']++ > 0) return false;
            }
        }
        
        
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                int[] square = new int[10];
                for(int k = 0; k < 3; ++k) {
                    for(int p = 0; p < 3; ++p) {
                        if(board[i * 3 + k][j * 3 + p] != '.' && square[board[i * 3 + k][j * 3 + p] - '0']++ > 0) return false;
                    }
                }
            }
        }
        
        return true;
    }
}
