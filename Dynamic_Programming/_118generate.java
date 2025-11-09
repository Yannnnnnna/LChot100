import java.util.ArrayList;
import java.util.List;

/**
 * @author wyr on 2025/11/9
 */
public class _118generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //添加第一行
        List<Integer> fist = new ArrayList<>();
        fist.add(1);
        result.add(fist);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(i -1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j -1) + prev.get(j));
            }
            curr.add(1);
            result.add(curr);
        }
        return result;
    }

}
