import java.util.ArrayList;
import java.util.List;

/**
 * @author wyr on 2025/10/15
 */
public class _46permute {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n];
        dfs(nums,path, used, res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        // 递归终止
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        // 变量所有可选的数字
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;

            //进入下一层
            dfs(nums,path,used,res);
            //撤销, 进行回溯
            used[i] = false;
            path.remove(path.size() - 1);

        }
    }


}
