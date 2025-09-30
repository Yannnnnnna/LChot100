/**
 * @author wyr on 2025/9/30
 */
public class _144flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先拉平左子树和右子树
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 将左子树插入到右子树的位置
        root.left = null;
        root.right = left;
        // 将原来的右子树接到左子树的最右节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
