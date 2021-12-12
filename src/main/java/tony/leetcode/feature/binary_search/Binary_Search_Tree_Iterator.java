package tony.leetcode.feature.binary_search;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 173. 二叉搜索树迭代器
// 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。

// 提示：
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。

public class Binary_Search_Tree_Iterator {

    private Deque<TreeNode> stack = new LinkedList<>();

    public Binary_Search_Tree_Iterator(TreeNode root) {
        pushNode(root);
    }

    /** @return the next smallest number */
    public int next() {
        // 最后的左子节点最小
        TreeNode min = stack.pop();
        // 初始化节点的右子节点
        pushNode(min.right);
        return min.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushNode(TreeNode node) {
        // 左子节点压栈
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
