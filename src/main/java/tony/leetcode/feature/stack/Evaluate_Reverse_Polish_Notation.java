package tony.leetcode.feature.stack;


// 150 逆波兰表达式求值
// 根据逆波兰表示法，求表达式的值。
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//
// 说明：
//
// 整数除法只保留整数部分。
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

// 示例 1：
// 输入: ["2", "1", "+", "3", "*"]
// 输出: 9
// 解释: ((2 + 1) * 3) = 9

// 示例 2：
// 输入: ["4", "13", "5", "/", "+"]
// 输出: 6
// 解释: (4 + (13 / 5)) = 6

import java.util.ArrayDeque;
import java.util.Deque;

public class Evaluate_Reverse_Polish_Notation {

    // 逆波兰表达式可描述为遇到运算符就在栈中取值进行计算，为了保证连续性，计算后的值也要放入栈中
    public int evalRPN(String[] tokens) {
        Deque<Integer> valStack = new ArrayDeque<>();
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                valStack.addLast(num);
            } catch (NumberFormatException ignore) {
                Integer one = valStack.pollLast();
                Integer two = valStack.pollLast();
                int val = 0;
                if ("+".equals(token)) {
                    val = two + one;
                } else if ("-".equals(token)) {
                    val = two - one;
                } else if ("*".equals(token)) {
                    val = two * one;
                } else if ("/".equals(token)) {
                    val = two / one;
                }
                valStack.addLast(val);
            }
        }

        return valStack.pollLast();
    }
}
