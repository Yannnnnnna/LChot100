/**
 * @author wyr on 2025/9/27
 */
public class _98isValidBST {
//    //递归+上下界
//    public boolean isValidBST(TreeNode root) {
//       if (root == null) {
//           return true;
//       }
//         return validate(root, null, null);
//    }
//
//    private boolean validate(TreeNode root, Long min, Long max) {
//        if (root == null){
//            return true;
//        }
//        if (min != null && root.val <= min) {
//            return false;
//        }
//        if (max != null && root.val >= max) {
//            return false;
//        }
//        // 递归检查左右子树
//        // 1. 对于左子树，它的所有节点都必须小于当前节点的值，所以更新上界为 node.val
//        // 2. 对于右子树，它的所有节点都必须大于当前节点的值，所以更新下界为 node.val
//        return validate(root.left, min, (long) root.val) &&
//                validate(root.right, (long) root.val, max);
//    }
    //中序遍历
    private Long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root== null){
            return true;
        }
        // 中序遍历左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 检查当前节点的值是否大于前一个节点的值
        if (root.val <= prev) {
            return false;
        }
        prev = (long) root.val;
        // 中序遍历右子树
        return isValidBST(root.right);
    }
}
