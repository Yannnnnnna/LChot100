import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyr on 2025/10/15
 */
public class _39combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res  = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, candidates, path, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, List<Integer> path, int target, int start) {
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            dfs(res, candidates, path, target-candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

}
