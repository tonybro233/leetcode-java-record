package tony.sword_to_offer;

import tony.util.ListNode;

// 25. 合并两个排序的链表
// 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

// 限制：
// 0 <= 链表长度 <= 1000

public class _25_merge_two_list {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (null != l1) {
            node.next = l1;
        } else if (null != l2) {
            node.next = l2;
        }

        return root.next;
    }

    // 递归解法
    public ListNode merge(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}
