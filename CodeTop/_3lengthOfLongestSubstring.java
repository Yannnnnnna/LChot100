import java.util.HashSet;
import java.util.Set;

/**
 * @author wyr on 2026/2/21
 */
public class _3lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int l= 0;
        for (int right = 0; right < n; right++) {
            // 如果当前字符已经在集合中，说明出现了重复字符，需要移动左指针
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(l));
                l++;
            }
            // 添加当前字符到集合中
            set.add(s.charAt(right));
            // 更新最大长度
            maxLength = Math.max(maxLength, right - l + 1);
        }
        return maxLength;
    }
}
