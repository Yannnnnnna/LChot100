import java.util.List;

/**
 * @author wyr on 2025/11/10
 */
public class _139wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len) { //确保不越界
                    boolean mach = s.substring(i - len, i).equals(word); //检查字符是否匹配
                    if (dp[i - len] && mach) { //前面都能匹配成功
                        dp[i] = true;
                        break;
                    }
                }

            }
        }
      return dp[s.length()];
    }
}
