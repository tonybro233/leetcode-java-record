package tony.sword_to_offer;

// 08. 二叉树的下一个节点
// 给定一颗二叉树和其中的一个节点，找出中序遍历序列的下一个节点。
// 树中的节点除了左右指针还包括指向父节点的指针

import tony.util.ParentTreeNode;

public class _08_next_inorer_node {

    public ParentTreeNode nextInorderNode(ParentTreeNode node) {
        if (null == node) {
            throw new IllegalStateException("Should not be null");
        }

        if (null != node.getRight()) {
            // 右子节点不为空，取右子节点的最左子节点
            node = node.getRight();
            while (null != node.getLeft()) {
                node = node.getLeft();
            }
            return node;
        } else {
            ParentTreeNode parent = node.getParent();
            while (null != parent) {
                if (parent.getLeft() == node) {
                    // 父节点的左子节点，返回父节点
                    return parent;
                } else {
                    // 父节点右子节点，继续向上处理
                    node = parent;
                    parent = parent.getParent();
                }
            }
            return null;
        }
    }


}
