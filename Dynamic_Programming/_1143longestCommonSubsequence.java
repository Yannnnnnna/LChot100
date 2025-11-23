/**
 * @author wyr on 2025/11/23
 */
public class _1143longestCommonSubsequence {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int n = text1.length();
//        int m = text2.length();
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                char c1 = text1.charAt(i -1);
//                char c2 = text2.charAt(j -1);
//                if (c1 == c2){
//                    dp[i][j] = 1+ dp[i-1][j-1];
//                }else {
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j -1]);
//                }
//            }
//        }
//        return dp[n][m];
//    }

        //进行空间优化
        public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        if(n < m){
            return longestCommonSubsequence(text2,text1);
        }
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int leftTop = 0;
            for (int j = 1; j <= m; j++) {
                char c1 = text1.charAt(i -1);
                char c2 = text2.charAt(j -1);
                int curTop = dp[j];
                if (c1 == c2){
                    dp[j] = 1+ leftTop;
                }else {
                    dp[j] = Math.max(curTop, dp[j -1]);
                }
                leftTop = curTop;
            }
        }
        return dp[m];
    }

}
