package tony.leetcode.level.simple;

import tony.util.TreeNode;

import java.util.*;

// 101
// 给定一个二叉树，检查它是否是镜像对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//    / \
//   2   2
//    \   \
//    3    3
// 说明:
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

public class Symmetric_Tree {

    public boolean isSymmetric(TreeNode root) {
        // return midorder(root, new ArrayList<>(), root, null);
        if (null == root){
            return true;
        }
        return compare(root.left, root.right);
    }

    // 递归解法
    private boolean compare(TreeNode left, TreeNode right){
        if (null == left && null == right){
            return true;
        }
        if (null != left && null != right && left.val == right.val){
            return compare(left.left, right.right) && compare(left.right, right.left);
        }
        return false;
    }

    // 迭代解法
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 注意java的队列一般不让插入null
        Deque<TreeNode> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        if (root.left == null && root.right == null){
            return true;
        }
        try {
            q1.push(root.left);
            q2.push(root.right);
        }catch (NullPointerException e){
            return false;
        }

        while (null != q1.peek() && null != q2.peek()) {
            TreeNode node1 = q1.pop();
            TreeNode node2 = q2.pop();

            if (node1.val != node2.val) {
                return false;
            }
            boolean null1 = false, null2 = false;
            if (null != node1.left && null != node2.right){
                q1.push(node1.left);
                q2.push(node2.right);
            } else if (null == node1.left && null == node2.right){
                null1 = true;
            } else {
                return false;
            }
            if (null != node1.right && null != node2.left){
                q1.push(node1.right);
                q2.push(node2.left);
            } else if (null == node1.right && null == node2.left){
                null2 = true;
            } else {
                return false;
            }
            if (null1 && null2){
                return true;
            }
        }
        return true;
    }

    // 使用中序遍历本身就是错误的，无法辨别如下的结构
    //     1
    //    / \
    //   2   2
    //    \   \
    //    3    3
    private boolean midorder(TreeNode node, List<Integer> vals, TreeNode root, Integer midpos){
        if (null == node){
            return true;
        }
        if (!midorder(node.left, vals, root, midpos)) {
            return false;
        }

        if (node.equals(root)){
            midpos = vals.size();
        } else if (null != midpos) {
            // 这样只检查了后半部分是否对称，如果不存在后半部分出现错误解
            int pos = midpos - (vals.size() - midpos);
            if (pos < 0 || vals.get(pos) != node.val){
                return false;
            }
        }
        vals.add(node.val);
        System.out.println(node.val);

        if (!midorder(node.right, vals, root, midpos)){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        System.out.println(new Symmetric_Tree().isSymmetric2(root));
    }

}
