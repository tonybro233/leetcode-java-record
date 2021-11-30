package tony.sword_to_offer;

import tony.util.TreeNode;

// 26. 树的子结构
// 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
// 例如:
// 给定的树 A:
//      3
//     / \
//    4   5
//   / \
//  1   2

// 给定的树 B：
//    4 
//   /
//  1
// 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

public class _26_sub_tree {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }

        return contain(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean contain(TreeNode A, TreeNode B) {
        if (null == B) {
            return true;
        }
        if (null == A) {
            return false;
        }

        return A.val == B.val && contain(A.left, B.left) && contain(A.right, B.right);
    }




}
