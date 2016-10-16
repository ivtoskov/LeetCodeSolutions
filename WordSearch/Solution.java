public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (dfs(board, i, j, wordChars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, char[] chars, int index) {
        if (index == chars.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '#' || board[i][j] != chars[index]) {
            return false;
        }
        
        char c = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, i + 1, j, chars, index + 1) ||
                        dfs(board, i - 1, j, chars, index + 1) ||
                        dfs(board, i, j + 1, chars, index + 1) ||
                        dfs(board, i, j - 1, chars, index + 1);
        
        board[i][j] = c;
        return found;
    }
}
