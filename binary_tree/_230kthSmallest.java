import java.util.Stack;

/**
 * @author wyr on 2025/9/27
 */
public class _230kthSmallest {
//    //栈解法
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()){
//            while (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            if(--k == 0){
//                return cur.val;
//            }
//            cur = cur.right;
//        }
//        return -1;
//    }
    // 递归解法
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        // 每次调用主函数时，重置状态变量
        this.count = 0;
        this.result = -1; // 或者其他标记值
        inorder(root, k);
        return this.result;
    }

    private void inorder(TreeNode node, int k) {
        // 如果节点为空，或者已经找到了答案，就直接返回
        if (node == null || this.count >= k) {
            return;
        }

        // 1. 遍历左子树
        inorder(node.left, k);

        // 如果在左子树中已经找到了第k个元素，就不再需要访问当前节点和右子树
        if (this.count >= k) {
            return;
        }

        // 2. 访问当前节点
        this.count++;
        if (this.count == k) {
            this.result = node.val;
            return; // 找到答案，立即返回
        }

        // 3. 遍历右子树
        inorder(node.right, k);
    }
}
