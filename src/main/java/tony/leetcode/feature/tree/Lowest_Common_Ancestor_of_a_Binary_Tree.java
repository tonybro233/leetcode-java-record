package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 236. 二叉树的最近公共祖先
// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
// 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归自身，查看p，q处于左子树还是右子树，分类讨论
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l == null && r == null) {
            // 不在本节点下
            return null;
        }
        if (l != null && r != null) {
            // 分别在左右子树，则共祖为root
            return root;
        } else {
            // 都在一个子树下
            return l != null ? l : r;
        }
    }

    // 丑陋的dfs解法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }

        Deque<TreeNode> pathp = new ArrayDeque<>();
        Deque<TreeNode> pathq = new ArrayDeque<>();
        boolean b1 = findPath(root, p, pathp);
        boolean b2 = findPath(root, q, pathq);
        if (!b1 || !b2) {
            return null;
        }
        TreeNode result = null;
        while (null != pathp.peekFirst() && null != pathq.peekFirst()) {
            TreeNode tmp = pathp.pollFirst();
            if (!tmp.equals(pathq.pollFirst())) {
                return result;
            }
            result = tmp;
        }

        return result;
    }

    private boolean findPath(TreeNode node, TreeNode target, Deque<TreeNode> stack) {
        stack.addLast(node);
        if (node == target) {
            return true;
        }
        boolean b = false;
        if (null != node.left) {
            b = findPath(node.left, target, stack);
        }
        if (!b && null != node.right) {
            b = findPath(node.right, target, stack);
        }

        if (!b) {
            stack.pollLast();
        }

        return b;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        root.left = n5;
        root.right = n1;
        n5.left = n6;
        n5.right = n2;
        n2.left = n7;
        n2.right = n4;
        n1.left = n0;
        n1.right = n8;
        Lowest_Common_Ancestor_of_a_Binary_Tree obj = new Lowest_Common_Ancestor_of_a_Binary_Tree();
        // Deque<TreeNode> path = obj.findPath(root, n0, new ArrayDeque<>());
        // for (TreeNode node : path){
        //     System.out.println(node.val);
        // }
        TreeNode node = obj.lowestCommonAncestor(root, root, n5);
        System.out.println(node.val);
    }
}

