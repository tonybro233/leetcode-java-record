package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 24. 两两交换链表中的节点
// 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 示例:
// 给定 1->2->3->4, 你应该返回 2->1->4->3.

// 说明:
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

public class Swap_Nodes_in_Pairs {

    // 维护处理中的头节点
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = head.next;
        ListNode first = head, second = null, father = new ListNode(0);
        while (first != null && (second = first.next) != null){
            ListNode nextFirst = second.next;
            second.next = first;
            father.next = second;
            first.next = nextFirst;
            father = first;
            first = nextFirst;
        }

        return result;
    }

    // 不够好
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = head.next;
        ListNode father = null;
        ListNode first = head, second = null;

        while (first != null){
            second = first.next;
            if (null == second){
                if (null != father){
                    father.next = first;
                }
                return result;
            }
            if (null != father){
                father.next = second;
            }

            ListNode next = second.next;
            second.next = first;
            father = first;
            first = next;
        }

        father.next = null;

        return result;
    }
}
