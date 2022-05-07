package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 234. 回文链表
// 请判断一个链表是否为回文链表。
//
// 示例 1:
// 输入: 1->2
// 输出: false

// 示例 2:
// 输入: 1->2->2->1
// 输出: true

// 进阶：
// 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

public class Palindrome_Linked_List {

    public boolean isPalindrome(ListNode head) {
        // 要达到O(1)空间需要修改原来的链表

        // OJ认为null也是符合条件
        // if (null == head){
        //     return true;
        // }

        // 快慢指针找到中点
        ListNode slow = head, fast = head, prev = null;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }

        // 翻转后半部分链表
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 校验，因为翻转的链表长度小于等于前面的链表长度，
        // 所以使用如下判断条件可以不考虑长度是奇数还是偶数
        while (prev != null && head != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = null, next = null;
        boolean odd = false;
        // 快慢指针找到中点(slow会指向中点或者中点后一个位置)，同时翻转遍历过程中的链表
        while (fast != null) {
            if (fast.next == null) {
                odd = true;
                fast = null;
            } else {
                fast = fast.next.next;
            }

            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if (odd && null != pre) {
            pre = pre.next;
        }

        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }
}
