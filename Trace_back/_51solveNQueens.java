import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyr on 2025/10/17
 */
public class _51solveNQueens {
    private static boolean[] usedCol;
    private static boolean[] usedDiag1;
    private static boolean[] usedDiag2;
    private  static List<List<String>> res;
    private int n;
    private char[][] map;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        usedCol = new boolean[n];
        usedDiag1 = new boolean[2*n - 1];
        usedDiag2 = new boolean[2*n - 1];
        //初始化
        this.n = n;
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], '.');
        }
        dfs(0);
        return res;
    }

    private void dfs(int row) {
        if (row == n){
            res.add(new ArrayList<String>(charTOArray(map)));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (usedCol[col] || usedDiag1[row - col + n -1] || usedDiag2[row + col]){
                continue;
            }
            map[row][col] = 'Q';
            usedCol[col] = true;
            usedDiag1[row - col + n -1] = true;
            usedDiag2[row + col] = true;
            dfs(row + 1);

            //撤销递归
            map[row][col] = '.';
            usedCol[col] = false;
            usedDiag1[row - col + n -1] = false;
            usedDiag2[row + col] = false;
        }
    }

    private List<String> charTOArray(char[][] map) {
       List<String> list = new ArrayList<>();
       for (char[] c: map){
           list.add(new String(c));
       }
        return list;
    }
}
