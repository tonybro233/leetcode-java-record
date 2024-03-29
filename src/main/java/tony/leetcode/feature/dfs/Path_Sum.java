package tony.leetcode.feature.dfs;

import tony.util.TreeNode;

// 112. 路径总和
// 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
// 给定如下二叉树，以及目标和 sum = 22，
//
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \      \
//         7    2      1
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

public class Path_Sum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }



    public boolean hasPathSum2(TreeNode root, int sum) {
        return search(root, sum);
    }

    private boolean search(TreeNode node, int left) {
        if (null == node) {
            return false;
        }
        if (node.val == left) {
            // 必须是叶子节点
            if (node.left == null && node.right == null) {
                return true;
            } else {
                // 可能有负数
                // return false;
            }
        }
        // 可能有负数
        // if (node.val > left){
        //     return false;
        // }
        return search(node.left, left - node.val) || search(node.right, left - node.val);
    }
}
