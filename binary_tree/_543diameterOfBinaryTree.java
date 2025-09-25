/**
 * @author wyr on 2025/9/25
 */
public class _543diameterOfBinaryTree {

    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
