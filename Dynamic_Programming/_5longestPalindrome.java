/**
 * @author wyr on 2025/11/22
 */
public class _5longestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1){
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        //遍历子串长度
        for (int L = 2; L <= n ; L++) {
            //遍历起始点位置
            for (int i = 0; i < n; i++) {
                int j = i + L - 1;
                if (j >= n) break;
                //起始点字符
                char l = s.charAt(i);
                char r = s.charAt(j);
                if (l != r) {
                    dp[i][j] = false;
                } else {
                    //1. 当前长度为2
                    if (L == 2) {
                        dp[i][j] = true;
                    }
                    //2.当前长度大于2
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && L >maxLen){
                    start = i;
                    maxLen = L;
                }
            }
        }
        return s.substring(start, start + maxLen);

    }
}
