package tony.sword_to_offer;

import tony.util.TreeNode;

// 55 - II. 平衡二叉树
// 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的
// 左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
// 示例 1:
// 给定二叉树 [3,9,20,null,null,15,7]
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回 true 。
//
// 示例 2:
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//        1
//       / \
//      2   2
//     / \
//    3   3
//   / \
//  4   4
// 返回 false 。

public class _55_2_is_binary_tree_balanced {

    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isBalanced(root.left) &&
                isBalanced(root.right) &&
                Math.abs(depth(root.left) - depth(root.right)) < 2;
    }

    private int depth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

}
