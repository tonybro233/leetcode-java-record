package tony.leetcode.feature.tree;

import tony.util.TreeNode;

public class Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    // 实际上应该是返回两个值: 高度、是否平衡，使用负数整合了这两点
    private int height(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int leftH = height(node.left);
        int rightH = height(node.right);
        if (leftH >= 0 && rightH >= 0 && Math.abs(leftH - rightH) <= 1) {
            return Math.max(leftH, rightH) + 1;
        } else {
            return -1;
        }
    }

    public boolean isBalanced2(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (isBalanced2(root.left) && isBalanced2(root.right)) {
            return Math.abs(height2(root.left) - height2(root.right)) <= 1;
        } else {
            return false;
        }
    }

    private int height2(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
