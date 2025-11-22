import java.util.Arrays;

/**
 * @author wyr on 2025/11/22
 */
public class _62uniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一行和第一列都只有一条路能走
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //从1,1开始移动
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i -1][j] + dp[i][j -1];
            }
        }
        return dp[m -1][n-1];
    }
}
