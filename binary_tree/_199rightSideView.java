import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wyr on 2025/9/27
 */
public class _199rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}

