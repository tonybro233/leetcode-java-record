package tony.sword_to_offer;

import tony.util.TreeNode;

// 07. 重建二叉树
// 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
// 返回如下的二叉树：
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//  
//
// 限制：
// 0 <= 节点个数 <= 5000

public class _07_rebuild_binary_tree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildNode(int[] preorder, int[] inorder, int ps, int is, int ie) {
        if (ie < is) {
            return null;
        }

        int rootVal = preorder[ps];
        Integer im = null;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == rootVal) {
                im = i;
                break;
            }
        }

        if (null == im) {
            throw new IllegalArgumentException("Invalid input data");
        }

        TreeNode node = new TreeNode(rootVal);
        node.left = buildNode(preorder, inorder, ps + 1, is, im - 1);
        node.right = buildNode(preorder, inorder, ps + im - is + 1, im + 1, ie);
        return node;
    }

}
