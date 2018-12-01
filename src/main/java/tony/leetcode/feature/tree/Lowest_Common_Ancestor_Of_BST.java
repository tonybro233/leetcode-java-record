package tony.leetcode.feature.tree;

import tony.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 235 二叉搜索树的最近公共祖先
// 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
// 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//         _______6______
//        /              \
//     ___2__          ___8__
//    /      \        /      \
//    0      _4       7       9
//          /  \
//          3   5
// 示例 1:
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// 输出: 6
// 解释: 节点 2 和节点 8 的最近公共祖先是 6。

// 示例 2:
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// 输出: 2
// 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。

// 说明:
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉搜索树中。

public class Lowest_Common_Ancestor_Of_BST {

    // 通过BST的性质得出以下形式
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor2(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }

    // 这种解法没有用到BST的性质，直接dfs取出路径进行比较
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>(), qPath = new ArrayList<>();
        dfs(root, pPath, p, qPath, q);
        TreeNode result = null;
        for (int i =0 ;i < Math.min(pPath.size(), qPath.size());i++){
            if (pPath.get(i).equals(qPath.get(i))){
                result = pPath.get(i);
            }
        }
        return result;
    }

    private void dfs(TreeNode node, List<TreeNode> pPath, TreeNode p , List<TreeNode> qPath, TreeNode q){
        if (node == null){
            return;
        }
        boolean pGet = false, qGet = false;
        if (pPath.size() == 0 || !p.equals(pPath.get(pPath.size()-1))){
            pPath.add(node);
            if (node.equals(p)){
                pGet = true;
            }
        }
        if (qPath.size() == 0 || !q.equals(qPath.get(qPath.size()-1))){
            qPath.add(node);
            if (node.equals(q)){
                qGet = true;
            }
        }
        if (pGet && qGet){
            return;
        }

        dfs(node.left, pPath, p, qPath, q);
        dfs(node.right, pPath, p, qPath, q);
        if (pPath.size() != 0 && !p.equals(pPath.get(pPath.size()-1))){
            pPath.remove(pPath.size()-1);
        }
        if (qPath.size() != 0 && !q.equals(qPath.get(qPath.size()-1))){
            qPath.remove(qPath.size()-1);
        }
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(9);
        TreeNode t8 = new TreeNode(3);
        TreeNode t9 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t8;
        t5.right = t9;
        t3.left = t6;
        t3.right = t7;

        TreeNode node = new Lowest_Common_Ancestor_Of_BST().lowestCommonAncestor(t1, t2, t3);
        System.out.println(node.val);
    }

}
