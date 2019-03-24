package tony.leetcode.feature.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 20. 有效的括号
// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
// 输入: "()"
// 输出: true

// 示例 2:
// 输入: "()[]{}"
// 输出: true

// 示例 3:
// 输入: "(]"
// 输出: false

// 示例 4:
// 输入: "([)]"
// 输出: false

// 示例 5:
// 输入: "{[]}"
// 输出: true

public class Valid_Parentheses {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Deque<Character> ll = new ArrayDeque<>(n);
        for (int i =0; i < n; i++){
            char c = chars[i];
            if (c == '(' || c == '[' || c == '{') {
                ll.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (ll.size() == 0 || c != rev(ll.pop())) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return ll.size() == 0;
    }

    private char rev(char c){
        switch (c) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return '0';
        }
    }
}
