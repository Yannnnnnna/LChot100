import java.util.HashMap;
import java.util.Map;

/**
 * @author wyr on 2025/7/18
 */
public class _3LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int l = 0, r = 0; r < n; r++) {
            char c = s.charAt(r);
            if(map.containsKey(c)){
                l = Math.max(map.get(c), l); // 更新左指针位置，确保不包含重复字符
            }
            max = Math.max(max, r - l + 1); // 更新最大长度
            map.put(c, r + 1); // 更新字符的最新索引位置
        }
        return max; // 返回最长子串的长度
    }
}
