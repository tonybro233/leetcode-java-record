package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 160. 相交链表
// 编写一个程序，找到两个单链表相交的起始节点。
//
// 注意：
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

public class Intersection_of_Two_Linked_Lists {

    // 思路很巧妙，某个链表结束后直接指向另一个链表，这两个节点就会同时走到第一个共有节点
    // 相当于两个变量都走了一遍共有部分和两个不共有部分
    // 判断尾节点相同保证有共有部分
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode endA = null, endB = null, currentA = headA, currentB = headB;
        if (null == currentB || null == currentA){
            return null;
        }
        while (true){
            if (currentA.equals(currentB)){
                return currentA;
            }
            if (currentA.next == null){
                endA = currentA;
                currentA = headB;
            } else {
                currentA = currentA.next;
            }
            if (currentB.next == null) {
                endB = currentB;
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
            if (null != endA && null != endB && !endA.equals(endB)){
                return null;
            }
        }
    }
}
