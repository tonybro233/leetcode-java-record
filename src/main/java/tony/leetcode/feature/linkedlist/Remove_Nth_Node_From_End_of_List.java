package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 19. 删除链表的倒数第N个节点
// 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
// 当删除了倒数第二个节点后，链表变为 1->2->3->5.

// 说明：
// 给定的 n 保证是有效的。
//
// 进阶：
// 你能尝试使用一趟扫描实现吗？

public class Remove_Nth_Node_From_End_of_List {

    // 要考虑好删除头结点的问题
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head){
            return null;
        }
        ListNode explorer = head, target = head, cursor = new ListNode(0);
        cursor.next = null;
        while (n > 0){
            explorer = explorer.next;
            n--;
        }

        while (null != explorer){
            explorer = explorer.next;
            cursor.next = target;
            target = target.next;
        }

        if (target == head){
            return head.next;
        } else {
            cursor.next.next = target.next;
            return head;
        }
    }
}
