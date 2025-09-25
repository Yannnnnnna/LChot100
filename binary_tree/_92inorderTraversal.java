import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wyr on 2025/9/25
 */
public class _92inorderTraversal {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorder(root, res);
//        return res;
//    }
//    private void inorder(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        inorder(node.left, res);
//        res.add(node.val);
//        inorder(node.right, res);
//    }

    //迭代解法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
