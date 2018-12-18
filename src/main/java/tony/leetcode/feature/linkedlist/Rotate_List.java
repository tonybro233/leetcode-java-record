package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 61. 旋转链表
// 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
// 输入: 1->2->3->4->5->NULL, k = 2
// 输出: 4->5->1->2->3->NULL
// 解释:
// 向右旋转 1 步: 5->1->2->3->4->NULL
// 向右旋转 2 步: 4->5->1->2->3->NULL

// 示例 2:
// 输入: 0->1->2->NULL, k = 4
// 输出: 2->0->1->NULL
// 解释:
// 向右旋转 1 步: 2->0->1->NULL
// 向右旋转 2 步: 1->2->0->NULL
// 向右旋转 3 步: 0->1->2->NULL
// 向右旋转 4 步: 2->0->1->NULL

public class Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {
        // 注意空节点和单节点
        if (k == 0 || null == head || head.next == null){
            return head;
        }
        int size = 0;
        ListNode tmp = head;
        ListNode oldEnd = null;
        while (tmp != null){
            if (tmp.next == null){
                oldEnd = tmp;
            }
            size++;
            tmp = tmp.next;
        }
        k %= size;
        // 注意整除
        if (k == 0){
            return head;
        }
        ListNode breakNode = head;
        ListNode newEnd = null;
        int left = size - k;
        while (left > 0){
            if (left == 1){
                newEnd = breakNode;
            }
            left--;
            breakNode = breakNode.next;
        }
        oldEnd.next = head;
        newEnd.next = null;
        return breakNode;
    }
}
