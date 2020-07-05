package tony.sword_to_offer;

import tony.util.ListNode;

// 52. 两个链表的第一个公共节点
// 输入两个链表，找出它们的第一个公共节点。

public class _52_intersect_node {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        boolean firstA = true, firstB = true;
        while (true) {
            if (nodeA == nodeB) {
                return nodeA;
            }

            if (nodeA == null) {
                if (firstA) {
                    firstA = false;
                    nodeA = headB;
                } else {
                    return null;
                }
            } else {
                nodeA = nodeA.next;
            }

            if (nodeB == null) {
                if (firstB) {
                    firstB = false;
                    nodeB = headA;
                } else {
                    return null;
                }
            } else {
                nodeB = nodeB.next;
            }
        }
    }

}
