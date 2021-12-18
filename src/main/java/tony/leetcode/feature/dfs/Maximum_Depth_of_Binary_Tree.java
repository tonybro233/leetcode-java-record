package tony.leetcode.feature.dfs;

import tony.util.TreeNode;

// 104
// 给定一个二叉树，找出其最大深度。
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
// 给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回它的最大深度 3 。

public class Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int now) {
        if (null == node) {
            return now;
        }
        now++;
        int l = dfs(node.left, now);
        int r = dfs(node.right, now);
        return Math.max(l, r);
    }
}
