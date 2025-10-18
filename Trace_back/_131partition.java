import java.util.ArrayList;
import java.util.List;

/**
 * @author wyr on 2025/10/17
 */
public class _131partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(res,path,s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, String s, int start) {
        if (start >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //检查是不是回文
            String tmp = s.substring(start, i+ 1);
            if (isPalindrome(s, start, i)){
                //是回文，添加进结果集，继续递归
                path.add(tmp);
                dfs(res,path, s, i + 1);
                path.remove(path.size() - 1);
            }
            //不是回文，尝试更长
        }
    }
    private static boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
