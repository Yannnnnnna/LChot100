import java.util.HashMap;
import java.util.Map;

/**
 * @author wyr on 2025/8/11
 */
public class _76MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return ""; // 如果s或t为空，或者s的长度小于t，直接返回空字符串
        }
        int left = 0, right = 0; // 滑动窗口的左右边界
        Map<String, Integer> need = new HashMap<>(); // 需要的字符及其数量
        Map<String, Integer> window = new HashMap<>(); // 当前窗口的字符及其数量

        for (char c : t.toCharArray()) {
            need.put(String.valueOf(c), need.getOrDefault(String.valueOf(c), 0) + 1); // 初始化需要的字符
        }
        int mach = 0; // 匹配的字符数量
        int minLength = Integer.MAX_VALUE; // 最小窗口长度
        int start = 0; // 最小窗口的起始位置
        while (right < s.length()) {
            String rightChar = String.valueOf(s.charAt(right));
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1); // 扩大窗口，加入右边字符

            if (need.containsKey(rightChar) && window.get(rightChar).equals(need.get(rightChar))) {
                mach++; // 如果当前字符满足需要的数量，匹配数量加1
            }


            while (mach == need.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1; // 更新最小窗口长度
                    start = left; // 更新最小窗口的起始位置
                }
                String leftChar = String.valueOf(s.charAt(left));
                window.put(leftChar, window.get(leftChar) - 1); // 缩小窗口，移除左边字符
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    mach--; // 如果当前字符不再满足需要的数量，匹配数量减1
                }
                left++; // 左指针右移，缩小窗口
            }
            right++; // 右指针右移，扩大窗口
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength); // 返回最小窗口子串
    }


}

