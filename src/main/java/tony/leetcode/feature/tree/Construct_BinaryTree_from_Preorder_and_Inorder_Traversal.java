package tony.leetcode.feature.tree;

import tony.util.TreeNode;

// 105. 从前序与中序遍历序列构造二叉树
// 根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
// 你可以假设树中没有重复的元素。
//
// 例如，给出
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]

// 返回如下的二叉树：
//     3
//    / \
//   9  20
//     /  \
//    15   7

public class Construct_BinaryTree_from_Preorder_and_Inorder_Traversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (is > ie) {
            return null;
        }
        int rootVal = preorder[ps];
        int im = is;
        while (im < ie && inorder[im] != rootVal) {
            im++;
        }
        TreeNode root = new TreeNode(rootVal);
        // im - is = 左子节点个数
        root.left = buildTree(preorder, ps + 1, ps + im - is, inorder, is, im - 1);
        root.right = buildTree(preorder, ps + im - is + 1, pe, inorder, im + 1, ie);
        return root;
    }
}
