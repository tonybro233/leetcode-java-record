package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 145. 二叉树的后序遍历
// 给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
// 输入: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
// 输出: [3,2,1]

// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

public class Binary_Tree_Postorder_Traversal {


    // 非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (null == root){
            return result;
        }
        TreeNode last = null;
        stack.addLast(root);
        while (null != stack.peekLast()){
            TreeNode node = stack.peekLast();
            if (null == node.left && null == node.right){
                // 叶子节点
                last = stack.pollLast();
                continue;
            }
            if (null != node.right && last == node.right){
                // 右节点返回
                result.add(last.val);
                last = stack.pollLast();
                continue;
            }
            if (null == node.left){
                // 只有右节点
                stack.addLast(node.right);
            } else {
                if (last != node.left){
                    // 左节点入队
                    stack.addLast(node.left);
                } else {
                    // 左节点返回
                    result.add(last.val);
                    if (null != node.right){
                        stack.addLast(node.right);
                    } else {
                        last = stack.pollLast();
                    }
                }
            }
        }
        result.add(last.val);

        return result;
    }

    public static void main(String[] args){
        List<Integer> list = new Binary_Tree_Postorder_Traversal().postorderTraversal2(new TreeNode(1));
        System.out.println(list);

        // TreeNode n1 = new TreeNode(1);
        // TreeNode n2 = new TreeNode(2);
        // TreeNode n3 = new TreeNode(3);
        // n3.left = n1;
        // n1.right = n2;
        // List<Integer> list = new Binary_Tree_Postorder_Traversal().postorderTraversal2(n3);
        // System.out.println(list);
    }

    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        go(root, result);
        return result;
    }

    private void go(TreeNode node, List<Integer> result){
        if (null == node){
            return;
        }
        go(node.left, result);
        go(node.right, result);
        result.add(node.val);
    }
}
