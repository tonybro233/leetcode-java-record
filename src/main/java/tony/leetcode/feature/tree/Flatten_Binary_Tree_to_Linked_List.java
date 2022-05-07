package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 114 二叉树展开为链表
// 给你二叉树的根结点 root ，请你将它展开为一个单链表：
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，
// 而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
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
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？

public class Flatten_Binary_Tree_to_Linked_List {

    public void flatten2(TreeNode root) {
        // 一轮循环会把右子节点放到其对应节点后面，然后把左子节点放到右子节点，最后继续
        // 如果没有左子节点则刚好不用处理
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
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }
}
