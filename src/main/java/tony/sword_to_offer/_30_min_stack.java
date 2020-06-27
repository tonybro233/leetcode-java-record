package tony.sword_to_offer;

// 30. 包含min函数的栈
// 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
// 调用 min、push 及 pop 的时间复杂度都是 O(1)。

import java.util.ArrayDeque;
import java.util.Deque;

public class _30_min_stack {

    public static class MinStack {

        private Deque<Integer> stack;

        private Deque<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.addLast(x);
            if (null == min.peekLast() || min.peekLast() >= x) {
                min.addLast(x);
            }
        }

        public void pop() {
            Integer last = stack.pollLast();
            if (null != last) {
                if (min.peekLast().equals(last)) {
                    min.pollLast();
                }
            }
        }

        public int top() {
            return stack.peekLast();
        }

        public int min() {
            return min.peekLast();
        }
    }

}
