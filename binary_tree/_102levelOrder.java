import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wyr on 2025/9/27
 */
public class _102levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //1. 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            //2. 记录当前层的节点数
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            //3. 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                //4. 将当前节点的子节点入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            //5. 将当前层的结果添加到最终结果中
            res.add(level);
        }
        return res;
    }
}

