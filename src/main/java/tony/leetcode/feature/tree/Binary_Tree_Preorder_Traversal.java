package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 144. 二叉树的前序遍历
// 给定一个二叉树，返回它的 前序 遍历。
//
//  示例:
// 输入: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
//
// 输出: [1,2,3]
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

public class Binary_Tree_Preorder_Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        go(root, result);
        return result;
    }

    private void go(TreeNode node, List<Integer> result){
        if (null == node){
            return;
        }
        result.add(node.val);
        go(node.left, result);
        go(node.right, result);
    }
}
