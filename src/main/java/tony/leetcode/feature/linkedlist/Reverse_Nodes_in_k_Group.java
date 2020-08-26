package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 25. K 个一组翻转链表
// 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
// k 是一个正整数，它的值小于或等于链表的长度。
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 示例：
// 给你这个链表：1->2->3->4->5
//
// 当 k = 2 时，应当返回: 2->1->4->3->5
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
// 说明：
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

public class Reverse_Nodes_in_k_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, cur, next;
        while (true) {
            if (!hasKLeft(prev, k)) {
                break;
            }

            // 反转k个节点
            cur = prev.next;
            for (int i = 0; i < k - 1;i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }

            prev = cur;
        }

        return dummy.next;
    }

    private boolean hasKLeft(ListNode node, int k) {
        for (int i = 0; i <= k;i++) {
            if (node == null) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

}
