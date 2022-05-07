package tony.leetcode.feature.tree;

import tony.util.TreeNode;

// 543. 二叉树的直径
// 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
// 这条路径可能穿过也可能不穿过根结点。
//
// 示例 :
// 给定二叉树
//           1
//          / \
//         2   3
//        / \
//       4   5
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。

public class Diameter_of_Binary_Tree {

    private int ret = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        // 求边 -1
        return ret - 1;
    }

    private int depth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        // 每个节点作为顶点时的最大路径节点数是左右子树的高度之和 + 1
        int left = depth(node.left);
        int right = depth(node.right);
        ret = Math.max(ret, left + right + 1);
        return Math.max(left, right) + 1;
    }


}
