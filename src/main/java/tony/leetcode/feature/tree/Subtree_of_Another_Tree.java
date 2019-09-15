package tony.leetcode.feature.tree;

import tony.util.TreeNode;

// 572. 另一个树的子树
// 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
// s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
//
// 示例 1:
// 给定的树 s:
//      3
//     / \
//    4   5
//   / \
//  1   2
//
// 给定的树 t：
//    4
//   / \
//  1   2
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
//
// 示例 2:
// 给定的树 s：
//      3
//     / \
//    4   5
//   / \
//  1   2
//     /
//    0
//
// 给定的树 t：
//    4
//   / \
//  1   2
// 返回 false。

public class Subtree_of_Another_Tree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s /*&& null != t*/) {
            return false;
        }

        return isSubtree(s.left, t)
                || isSubtree(s.right, t)
                || isSametree(s, t);

    }

    private boolean isSametree(TreeNode s, TreeNode t) {
        return (s == null && t == null) ||
                (s != null
                && t != null
                && s.val == t.val
                && isSametree(s.left, t.left)
                && isSametree(s.right, t.right));
    }

}
