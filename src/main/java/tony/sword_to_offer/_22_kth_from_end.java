package tony.sword_to_offer;

import tony.util.ListNode;

// 22. 链表中倒数第k个节点
// 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾节点是倒数第1个节点。
// 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
// 这个链表的倒数第3个节点是值为4的节点。
//
// 示例：
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
// 返回链表 4->5.

public class _22_kth_from_end {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k < 1 || null == head) {
            throw new IllegalArgumentException();
        }

        ListNode p1 = head, p2 = head;

        for (int i = 0; i < k;i++) {
            if (null == p2) {
                return null;
            }
            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

}
