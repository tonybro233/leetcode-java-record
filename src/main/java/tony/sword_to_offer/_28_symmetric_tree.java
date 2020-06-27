package tony.sword_to_offer;

import tony.util.TreeNode;

// 28. 对称的二叉树
// 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//     1
//    / \
//   2   2
//    \   \
//    3    3
//
// 示例 1：
// 输入：root = [1,2,2,3,4,4,3]
// 输出：true

// 示例 2：
// 输入：root = [1,2,2,null,3,null,3]
// 输出：false

public class _28_symmetric_tree {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        } else if (null != left && null != right) {
            return left.val == right.val &&
                    compare(left.left, right.right) &&
                    compare(left.right, right.left);
        } else {
            return false;
        }
    }

}
