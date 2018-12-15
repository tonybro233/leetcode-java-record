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
        go(n, n, new StringBuilder(), result);
        return result;
    }

    // 使用回溯，核心是一定先放左括号，剩余的左括号小于有括号（也就是当前字符中左括号更多）就一定是合法的
    private void go(int left, int right, StringBuilder sb, List<String> result){
        if (left > right){
            // 左括号剩余数大于右括号，出现)(
            return ;
        }
        if (left == 0 && right == 0){
            result.add(sb.toString());
            return;
        }
        if (left == right){
            sb.append('(');
            go(left-1, right, sb, result);
            sb.deleteCharAt(sb.length()-1);
        } else {
            if (left > 0) {
                sb.append('(');
                go(left - 1, right, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(')');
            go(left, right-1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
