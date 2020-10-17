package tony.sword_to_offer;

import java.util.ArrayDeque;
import java.util.Deque;

// 31. 栈的压入、弹出序列
// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
// 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

public class _31_valid_pop_sequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (null == pushed || null == popped) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }

        int idx = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int pop : popped) {
            if (null != stack.peekLast() && stack.peekLast() == pop) {
                stack.pollLast();
            } else {
                boolean got = false;
                while (idx < pushed.length) {
                    if (pushed[idx] != pop) {
                        stack.addLast(pushed[idx++]);
                    } else {
                        got = true;
                        idx++;
                        break;
                    }
                }
                if (!got) {
                    return false;
                }
            }
        }

        return true;
    }

}