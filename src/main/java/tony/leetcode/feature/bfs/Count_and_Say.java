package tony.leetcode.feature.bfs;

// 38. 报数
// 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
// 其前五项如下：
//
// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
// 1 被读作  "one 1"  ("一个一") , 即 11。
// 11 被读作 "two 1s" ("两个一"）, 即 21。
// 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
//
// 注意：整数顺序将表示为一个字符串。

import java.util.ArrayDeque;
import java.util.Deque;

public class Count_and_Say {

    // 使用一个队列，相当于bfs
    public String countAndSay(int n) {
        if (n == 0){
            return "";
        }
        Deque<Character> deque = new ArrayDeque<>();
        deque.addFirst('1');
        while (n > 1){
            Character current = null;
            int count = 0;
            int m = deque.size();
            while (m > 0){
                if (current == null || current.equals(deque.peekFirst())){
                    count++;
                } else {
                    deque.addLast((char) ('0'+count));
                    deque.addLast(current);
                    count = 1;
                }
                current = deque.pollFirst();
                m--;
            }
            if (null != current){
                deque.addLast((char) ('0'+count));
                deque.addLast(current);
            }
            n--;
        }
        StringBuilder sb = new StringBuilder();
        while (null != deque.peekFirst()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

    // 循环生成char数组，基本一致
    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        String fir = "11";
        char[] ch = fir.toCharArray();
        int count = 1;
        int n1 = 0;
        while (n > 2) {
            StringBuilder sb = new StringBuilder();
            // 因为要比较前一个值，所以从11开始
            for (int i = 1; i < ch.length; i++) {
                n1 = ch[i];
                if (n1 == ch[i - 1]) {
                    count++;
                } else {
                    sb.append(count).append(ch[i - 1]);
                    count = 1;
                }
                if (i == ch.length - 1) {
                    sb.append(count).append(ch[i]);
                }
            }
            count = 1;
            ch = sb.toString().toCharArray();
            n--;
        }
        return String.valueOf(ch);

    }

    public static void main(String[] args){
        String s = new Count_and_Say().countAndSay(6);
        System.out.println(s);
    }
}
