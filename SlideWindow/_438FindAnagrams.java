import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyr on 2025/7/18
 */
public class _438FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int slen = s.length();
        int lenP = p.length();
        if (slen < lenP) {
            return res; // 如果s的长度小于p，直接返回空结果
        }
        // 统计p中每个字符的频率
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < lenP; i++) {
            pCount[p.charAt(i) - 'a']++; // 统计p中字符的频率
            sCount[s.charAt(i) - 'a']++; // 统计s中前lenP个字符的频率
        }
        if(Arrays.equals(sCount, pCount)){
            res.add(0); // 如果s的前lenP个字符和p的字符频率相同，添加索引0
        }
        // 使用滑动窗口遍历s
        for (int i = 0; i <slen - lenP; i++) {
            --sCount[s.charAt(i) - 'a']; // 移除左边界字符的频率
            ++sCount[s.charAt(i + lenP) - 'a']; // 添加右边界字符的频率

            if(Arrays.equals(sCount, pCount)) {
                res.add(i + 1); // 如果当前窗口的字符频率和p相同，添加当前索引
            }
        }
        return res; // 返回所有找到的索引
    }
}
