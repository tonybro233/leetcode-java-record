package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 114 二叉树展开为链表
// 给定一个二叉树，原地将它展开为链表。
//
// 例如，给定二叉树
//
//     1
//    / \
//   2   5
//  / \   \
// 3   4   6
// 将其展开为：
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6

public class Flatten_Binary_Tree_to_Linked_List {

    public void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    // 这个递归没看懂
    public void flatten(TreeNode root) {
        if(root==null) {
            return;
        }
        if(root.left!=null) {
            flatten(root.left);
        }
        if(root.right!=null) {
            flatten(root.right);
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null) {
            root = root.right;
        }
        root.right = temp;
    }
}
