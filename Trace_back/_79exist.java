/**
 * @author wyr on 2025/10/17
 */
public class _79exist {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (dfs(board, i, j, 0, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        // 1. 边界检查（更健壮的方式）
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        // 2. 字符不匹配，或者当前格子已被访问过
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() -1){
            return true;
        }
        char old = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, i + 1, j, index + 1, word )
                || dfs(board, i, j + 1, index + 1, word)
                || dfs(board, i - 1, j, index + 1, word)
                || dfs(board, i, j - 1, index + 1, word);
        board[i][j] = old;
        return found;
    }
}
