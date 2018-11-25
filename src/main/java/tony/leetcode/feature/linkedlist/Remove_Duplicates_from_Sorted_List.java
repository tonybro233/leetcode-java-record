package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 83
// 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
// 输出: 1->2
// 示例 2:
//
// 输入: 1->1->2->3->3
// 输出: 1->2->3

public class Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if (cur == null){
            return head;
        }
        while (cur.next != null){
            ListNode tmp = cur.next;
            if (cur.val == tmp.val){
                cur.next = tmp.next;
            } else {
                cur = tmp;
            }
        }
        return head;
    }
}
