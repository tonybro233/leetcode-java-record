package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 203. 移除链表元素
// 删除链表中等于给定值 val 的所有节点。
//
// 示例:
// 输入: 1->2->6->3->4->5->6, val = 6
// 输出: 1->2->3->4->5

public class Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        ListNode pre = pointer, current = head;
        while (current != null){
            ListNode next = current.next;
            if (current.val == val){
                pre.next = next;
            } else {
                pre = current;
            }
            current = next;
        }

        return pointer.next;
    }
}
