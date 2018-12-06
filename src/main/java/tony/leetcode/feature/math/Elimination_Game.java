package tony.leetcode.feature.math;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

// 390. 消除游戏
// 给定一个从1 到 n 排序的整数列表。
// 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
// 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
// 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
// 返回长度为 n 的列表中，最后剩下的数字。
//
// 示例：
// 输入:
// n = 9,
// 1 2 3 4 5 6 7 8 9
// 2 4 6 8
// 2 6
// 6
//
// 输出:
// 6

public class Elimination_Game {

    // 维护左侧起始值和数值间距
    public int lastRemaining2(int n){
        int remain = n;
        boolean left = true;
        int step = 1, res = 1;
        while (remain > 1) {
            if(left || remain % 2 == 1){
                res += step; // 左侧开始或右侧开始总数为奇数，则起始值前进
            }
            remain /= 2;
            step *= 2;
            left = !left;
        }
        return res;
    }

    // 完全按照规则进行编码的解。测试用例将会超时
    public int lastRemaining(int n) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n;i++){
            deque.addLast(i);
        }
        boolean back = false;
        Iterator<Integer> iterator;
        while (deque.size() > 1){
            if (back){
                iterator = deque.descendingIterator();
            } else {
                iterator = deque.iterator();
            }

            while (iterator.hasNext() && deque.size() > 1){
                iterator.next();
                iterator.remove();
                if (iterator.hasNext()){
                    iterator.next();
                }
            }
            back = !back;
        }

        return deque.peek();
    }

    public static void main(String[] args){
        int i = new Elimination_Game().lastRemaining2(12);
        System.out.println(i);
    }
}
