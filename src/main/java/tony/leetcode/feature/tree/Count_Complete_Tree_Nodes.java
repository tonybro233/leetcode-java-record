package tony.leetcode.feature.tree;

import tony.util.TreeNode;

// 222. 完全二叉树的节点个数
// 给出一个完全二叉树，求出该树的节点个数。
//
// 说明：
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
// 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
//
// 示例:
// 输入:
//     1
//    / \
//   2   3
//  / \  /
// 4  5 6
// 输出: 6

public class Count_Complete_Tree_Nodes {

    public int countNodes(TreeNode root) {
        // 如果是满二叉树，节点总数为2^h - 1
        if (null == root){
            return 0;
        }
        int count = 0;
        while (root != null){
            int ld = leftDepth(root.left);
            int rd = leftDepth(root.right);
            // 这个判断不容易想到
            if (ld == rd){
                // 左子树满
                count += Math.pow(2, ld); // 1 + (2^h - 1) , 算上根节点
                root = root.right;
            } else {
                // 右子树满
                count += Math.pow(2, rd);
                root = root.left;
            }
        }
        return count;
    }

    private int leftDepth(TreeNode node){
        return node == null ? 0 : leftDepth(node.left) + 1;
    }
}
