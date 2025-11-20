/**
 * @author wyr on 2025/11/20
 */
public class _32longestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for(int i = 0; i < s.length(); i++){
//            //1. 当前是（ 不能以（结尾，所以为0
//            if(s.charAt(i) == '('){
//                dp[i] = 0;
//            }
            //2. 当前是）
             if (s.charAt(i) == ')') {
                //2.1 前一个是（，刚好成对，结果就是当前加上以前两个结尾的数量
                if (i -1 >= 0 && s.charAt(i - 1) == '('){
                    dp[i] = 2;
                    if (i -2 >=0){
                        dp[i] += dp[i -2];
                    }
                }
                //2.2 前一个也是），
                // 说明（ 在更前面，查看 i - dp i -1 是不是（，同时加上（前面的结果 + 2 + （）中间的结果
                else if (i -1 >= 0 && s.charAt(i - 1) == ')'){
                    int j = i - dp[i-1] - 1;
                    if (j >= 0 && s.charAt(j) == '('){
                        dp[i] = 2 + dp[i - 1];
                        if (j -  1>= 0){
                            dp[i] += dp[j -1];
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
