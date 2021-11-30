package tony.sword_to_offer;

import tony.util.TreeNode;

// 27. 二叉树的镜像
// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9

// 镜像输出：
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
//
// 示例 1：
// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]

public class _27_mirror_tree {

    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

}
