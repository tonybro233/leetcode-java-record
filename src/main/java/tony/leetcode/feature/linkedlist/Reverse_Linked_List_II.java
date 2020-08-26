package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

// 92
// 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
// 1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
// 输出: 1->4->3->2->5->NULL

public class Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode aux = new ListNode(0);
        aux.next = head;
        ListNode prev = aux;
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;

        ListNode next;
        for (int i = m; i < n; i++) {
            // 表示每次移动一个节点到前面
            next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return aux.next;
    }

    // 写的什么屎玩意儿
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (n <= m){
            return head;
        }
        int i = 1;
        ListNode begin = head;
        while (i < m-1){
            if (begin == null){
                return head;
            }
            begin = begin.next;
            i++;
        }

        ListNode start = begin.next;
        // 处理直接从开头开始反转
        if (m == 1){
            start = begin;
            begin = null;
            i--;
        }
        if (start == null){
            return head;
        }
        ListNode cur = start;
        ListNode cursor = new ListNode(0);
        while (i < n){
            ListNode next = cur.next;
            cur.next = cursor.next;
            cursor.next = cur;
            cur = next;
            i++;
        }

        start.next = cur;
        if (m == 1){
            head = cursor.next;
        } else {
            begin.next = cursor.next;
        }


        return head;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        new Reverse_Linked_List_II().reverseBetween(n1,2,4);
        System.out.println("fuck");
    }
}
