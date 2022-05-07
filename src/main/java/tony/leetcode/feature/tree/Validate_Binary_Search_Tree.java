package tony.leetcode.feature.tree;

import tony.util.TreeNode;

// 98. 验证二叉搜索树
// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
// 提示：
// 树中节点数目范围在[1, 104] 内
// -231 <= Node.val <= 231 - 1

public class Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        // 千万记得不能只判断左右子节点与根节点的对比
        // 一定要注意处理判断左子节点的右子节点要小于根节点这种情况以及其他
        return isValidBST(root, (long) Integer.MAX_VALUE + 1, (long) Integer.MIN_VALUE - 1);
    }

    private boolean isValidBST(TreeNode node, long maxLimit, long minLimit) {
        if (null == node) {
            return true;
        }
        if (node.val >= maxLimit || node.val <= minLimit) {
            return false;
        }
        return isValidBST(node.left, node.val, minLimit)
                && isValidBST(node.right, maxLimit, node.val);
    }

}
