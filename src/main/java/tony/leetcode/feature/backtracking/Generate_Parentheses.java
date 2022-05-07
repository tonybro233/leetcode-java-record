package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.List;

// 22. 括号生成
// 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

public class Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, new StringBuilder(), result);
        return result;
    }

    // 使用回溯，核心是一定先放左括号，剩余的左括号小于有括号（也就是当前字符中左括号更多）就一定是合法的
    private void generate(int left, int right, StringBuilder buffer, List<String> result){
        if (left == 0 && right == 0) {
            result.add(buffer.toString());
            return;
        }

        if (left > 0) {
            buffer.append('(');
            generate(left - 1, right, buffer, result);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        if (left < right) {
            buffer.append(')');
            generate(left, right - 1, buffer, result);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
