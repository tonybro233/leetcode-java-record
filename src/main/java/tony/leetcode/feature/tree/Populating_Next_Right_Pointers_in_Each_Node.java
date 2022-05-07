package tony.leetcode.feature.tree;

import tony.util.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 116 填充同一层的兄弟节点
// 给定一个二叉树
// struct TreeLinkNode {
//   TreeLinkNode *left;
//   TreeLinkNode *right;
//   TreeLinkNode *next;
// }
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
// 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
// 说明:
// 你只能使用额外常数空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
// 你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。

// 示例:
// 给定完美二叉树，
//
//      1
//    /  \
//   2    3
//  / \  / \
// 4  5  6  7
// 调用你的函数后，该完美二叉树变为：
//
//      1 -> NULL
//    /  \
//   2 -> 3 -> NULL
//  / \  / \
// 4->5->6->7 -> NULL

public class Populating_Next_Right_Pointers_in_Each_Node {

    // 使用BFS，没有使用完美二叉树这个条件，对于不完美二叉树也适用
    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }
        Deque<TreeLinkNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (stack.peekFirst() != null) {
            int count = stack.size();
            TreeLinkNode current = null;
            for (int i = 0; i < count; i++) {
                TreeLinkNode node = stack.pollFirst();
                if (null != node.left) {
                    if (null == current) {
                        current = node.left;
                    } else {
                        current.next = node.left;
                        current = current.next;
                    }
                    stack.addLast(node.left);
                }
                if (null != node.right) {
                    if (null == current) {
                        current = node.right;
                    } else {
                        current.next = node.right;
                        current = current.next;
                    }
                    stack.addLast(node.right);
                }
            }
        }
    }

    // 不太一样的解法
    public void connect2(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        root.next = null;
        TreeLinkNode preHead = root;
        TreeLinkNode cur = root;
        while (preHead.left != null) {
            if (cur.next != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next.left;
            } else {
                cur.left.next = cur.right;
                cur.right.next = null;
                preHead = preHead.left;
                cur = preHead;
                continue;
            }
            cur = cur.next;
        }
    }
}
