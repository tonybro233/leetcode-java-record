package tony.leetcode.feature.linkedlist;

import tony.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 445. 两数相加 II
// 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。
// 将这两数相加会返回一个新的链表。
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

// 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// 输出: 7 -> 8 -> 0 -> 7

public class Add_Two_Numbers_II {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> a1 = new ArrayList<>();
        List<ListNode> a2 = new ArrayList<>();
        while (true){
            if (null != l1){
                a1.add(l1);
                l1 = l1.next;
            } else {
                break;
            }
        }

        while (true){
            if (null != l2){
                a2.add(l2);
                l2 = l2.next;
            } else{
                break;
            }
        }

        Collections.reverse(a1);
        Collections.reverse(a2);

        int max = Math.max(a1.size(),a2.size());
        ListNode begin = null, cursor = null;
        int adder = 0;
        for (int i = 0; i < max; i++){
            int val = adder;
            if (i < a1.size()){
                val += a1.get(i).val;
            }
            if (i < a2.size()){
                val += a2.get(i).val;
            }

            adder = val / 10;
            val = val % 10;

            ListNode current = new ListNode(val);
            if (null == begin){
                begin = current;
                cursor = current;
            } else {
                cursor.next = current;
                cursor = current;
            }
        }
        if (adder != 0){
            cursor.next = new ListNode(adder);
        }
        ListNode tmp = new ListNode(0);
        while (begin != null){
            ListNode next = begin.next;
            begin.next = tmp.next;
            tmp.next = begin;
            begin = next;
        }
        return tmp.next;
    }
}
