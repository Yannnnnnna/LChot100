import java.util.HashMap;

/**
 * @author wyr on 2025/10/8
 */
public class _105buildTree {
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    /**
     * 递归构建树的辅助函数
     * @param preorder 前序遍历数组
     * @param preStart 当前子树在前序遍历中的起始索引
     * @param preEnd   当前子树在前序遍历中的结束索引
     * @param inorder  中序遍历数组
     * @param inStart  当前子树在中序遍历中的起始索引
     * @param inEnd    当前子树在中序遍历中的结束索引
     * @return 构建好的子树的根节点
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //1. 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //2. 根节点是前序遍历的第一个元素
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //3. 在中序遍历中找到根节点的位置
        int rootIndex = inorderIndexMap.get(rootVal);
        //4. 计算左子树的节点数
        int leftSize = rootIndex - inStart;
        //5. 递归构建左子树和右子树
        // 构建左子树
        // - 左子树的前序遍历范围：preStart + 1 到 preStart + leftSize
        // - 左子树的中序遍历范围：inStart 到 rootIndexInorder - 1
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
        // 构建右子树
        // - 右子树的前序遍历范围：preStart + leftSize + 1 到 preEnd
        // - 右子树的中序遍历范围：rootIndexInorder + 1 到 inEnd
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
