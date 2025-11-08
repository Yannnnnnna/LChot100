import java.util.ArrayList;
import java.util.List;

/**
 * @author wyr on 2025/11/8
 */
public class _763partitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] letter = new int[26];
        //记录字符最后出现的地方
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //当前字符最后出现的地方
            int last = letter[s.charAt(i)  - 'a'];
            //更新end
            end = Math.max(end, last);
            //到达边界
            if (i == end){
                int len = i - start +1;
                result.add(len);
                start = i + 1;
            }
        }
       return result;
    }
}
