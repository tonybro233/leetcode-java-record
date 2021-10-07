package tony.leetcode.feature.string;

// 316. 去除重复字母
// 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
// 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

// 示例 1：
// 输入：s = "bcabc"
// 输出："abc"

// 示例 2：
// 输入：s = "cbacdcbc"
// 输出："acdb"
//  
// 提示：
// 1 <= s.length <= 104
// s 由小写英文字母组成

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class Remove_Duplicate_Letters {

    // 优化
    public String removeDuplicateLetters2(String s) {
        // 记录是否元素在栈中
        boolean[] vis = new boolean[26];
        // 记录剩下的元素个数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!vis[c - 'a']) {
                while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                    Character pop = stack.pop();
                    vis[pop - 'a'] = false;
                }
                stack.push(c);
                vis[c - 'a'] = true;
            }
            count[c - 'a']--;
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }

    // 原始思路描述解法
    public String removeDuplicateLetters(String s) {
        // 使用栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 栈中元素不重复
            if (stack.contains(c))
                continue;
            // 如果栈顶比当前元素大且栈顶元素在当前元素后面还会出现，则pop出栈
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1)
                stack.pop();
            // 压入当前元素
            stack.push(c);
        }

        // 创建结果
        char[] chars = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }

}
