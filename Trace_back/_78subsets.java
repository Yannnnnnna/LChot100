import java.util.ArrayList;
import java.util.List;

/**
 * @author wyr on 2025/10/15
 */
public class _78subsets {

    //回溯法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res,0, path, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, int i, List<Integer> path, int[] nums) {
        res.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            //将当前数字加入结果
            path.add(nums[j]);
            dfs(res,  j+ 1, path, nums);
            path.remove(path.size() - 1);
            //不将当前数字加入索引
        }
    }
}
