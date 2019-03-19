package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

import java.nio.channels.Channel;
import java.util.Arrays;
import java.util.Scanner;

// 147 对链表进行插入排序
// 对链表进行插入排序。
// 插入排序算法：
//
// 1.插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 2.每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 4.重复直到所有输入数据插入完为止。

// 示例 1：
// 输入: 4->2->1->3
// 输出: 1->2->3->4

public class Insertion_Sort_List {

    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode headPointer = new ListNode(0);
        headPointer.next = head;
        ListNode current = head.next;
        ListNode before = head;
        int pos = 1;
        while (current != null){
            ListNode next = current.next;
            ListNode now = headPointer;
            boolean changed = false;
            for (int i = 0;i < pos;i++){
                ListNode nownext = now.next;
                if (current.val < nownext.val){
                    now.next = current;
                    current.next = nownext;

                    before.next = next;
                    current = next;
                    changed = true;
                    break;
                }
                now = now.next;
            }
            if (!changed){
                before = current;
                current = next;
            }

            pos++;
        }
        return headPointer.next;
    }
}
