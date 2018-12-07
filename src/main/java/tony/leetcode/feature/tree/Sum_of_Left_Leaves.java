package tony.leetcode.feature.tree;

import tony.util.TreeNode;

// 404. 左叶子之和
// 计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

public class Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return goDfs(root, false,0); // 根节点不算左叶子
    }

    private int goDfs(TreeNode node, boolean left,int sum){
        if (null == node){
            return sum;
        }

        if (node.left == null && node.right == null && left){
            sum += node.val;
        } else {
            sum = goDfs(node.left, true, sum);
            sum = goDfs(node.right, false, sum);
        }

        return sum;
    }
}
