package tony.leetcode.feature.tree;

import tony.util.TreeNode;

// 106. 从中序与后序遍历序列构造二叉树
// 根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
// 你可以假设树中没有重复的元素。
//
// 例如，给出
// 中序遍历 inorder = [9,3,15,20,7]
// 后序遍历 postorder = [9,15,7,20,3]

// 返回如下的二叉树：
//     3
//    / \
//   9  20
//     /  \
//    15   7

public class Construct_BinaryTree_from_Inorder_and_Postorde_Traversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie) {
            return null;
        }
        // 后序遍历最后一个节点为根节点
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        // 确定根节点在中序遍历中的位置
        int im = is;
        while (im < ie && inorder[im] != rootVal) {
            im++;
        }
        // 根据根节点在中序遍历中的位置得到左右子树的中序遍历和后序遍历序列
        // im - is = 左子树节点数量，以此来拆解后序遍历的内容
        root.left = buildTree(inorder, is, im - 1, postorder, ps, ps + (im - 1 - is));
        root.right = buildTree(inorder, im + 1, ie, postorder, ps + (im - is), pe - 1);
        return root;
    }
}
