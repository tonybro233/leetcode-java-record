package tony.leetcode.feature.stack;

// 32. 最长有效括号
// 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 示例 1：
// 输入：s = "(()"
// 输出：2
// 解释：最长有效括号子串是 "()"

// 示例 2：
// 输入：s = ")()())"
// 输出：4
// 解释：最长有效括号子串是 "()()"

// 示例 3：
// 输入：s = ""
// 输出：0
//  
// 提示：
// 0 <= s.length <= 3 * 104
// s[i] 为 '(' 或 ')'

import java.util.ArrayDeque;
import java.util.Deque;

public class Longest_Valid_Parentheses {

    public int longestValidParentheses(String s) {
        int result = 0;
        // 核心是孤立的右括号会中断连续
        // 左括号和孤立的右括号插入栈中
        // 右括号会使得左括号弹栈，孤立的右括号不会被弹出，以此维护当前的起始位置
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(i);
            } else {
                stack.pollLast();
                if (stack.isEmpty()) {
                    stack.addLast(i);
                } else {
                    result = Math.max(result, i - stack.peekLast());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // ()()()
        // ()(())
        // ())()
        int res = new Longest_Valid_Parentheses().longestValidParentheses("(((()");
        System.out.println(res);
    }

}
