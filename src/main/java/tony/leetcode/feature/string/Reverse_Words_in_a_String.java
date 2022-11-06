package tony.leetcode.feature.string;

// 151. 颠倒字符串中的单词
// 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
// 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
//
// 示例 1：
// 输入：s = "the sky is blue"
// 输出："blue is sky the"

// 示例 2：
// 输入：s = "  hello world  "
// 输出："world hello"
// 解释：颠倒后的字符串中不能存在前导空格和尾随空格。

// 示例 3：
// 输入：s = "a good   example"
// 输出："example good a"
// 解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
//  
// 提示：
// 1 <= s.length <= 104
// s 包含英文大小写字母、数字和空格 ' '
// s 中 至少存在一个 单词
//  
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。

import java.util.StringJoiner;

public class Reverse_Words_in_a_String {

    public static void main(String[] args) {
        System.out.println(new Reverse_Words_in_a_String().reverseWords2("  hello world  "));
    }

    public String reverseWords3(String s) {
        // 常规解法
        StringBuilder buffer = new StringBuilder();
        int idx = findLetter(s, 0);
        while (idx < s.length()) {
            int end = findSpace(s, idx);
            buffer.append(reverse(s, idx, end));
            buffer.append(' ');
            idx = findLetter(s, end);
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.reverse().toString();
    }

    private int findLetter(String s, int idx) {
        for (; idx < s.length(); idx++) {
            if (s.charAt(idx) != ' ') {
                break;
            }
        }
        return idx;
    }

    private int findSpace(String s, int idx) {
        for (; idx < s.length(); idx++) {
            if (s.charAt(idx) == ' ') {
                break;
            }
        }
        return idx;
    }

    private String reverse(String s, int begin, int end) {
        return new StringBuilder(s.substring(begin, end)).reverse().toString();
    }

    public String reverseWords2(String s) {
        // 调包侠解法
        String[] strs = s.trim().split("\\s+");
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            joiner.add(strs[i]);
        }
        return joiner.toString();
    }

    public String reverseWords(String s) {
        // 原地解法
        char[] chars = s.toCharArray();
        int st = findNext(chars, 0);
        int pos = 0;
        int ed;
        while (st < chars.length) {
            ed = findLast(chars, st);
            reverse(chars, st, ed);
            pos = moveBack(chars, pos, st, ed);
            if (pos < chars.length - 1) {
                chars[pos + 1] = ' ';
                pos += 2;
            } else {
                break;
            }
            st = findNext(chars, ed + 1);
            // 其实这样写也没啥大问题
            if (st >= chars.length) {
                pos -= 2;
            }
        }

        reverse(chars, 0, pos);
        return new String(chars, 0, pos + 1);
    }

    private int findNext(char[] chars, int st) {
        for (;st < chars.length;st++) {
            if (chars[st] != ' ') {
                break;
            }
        }
        return st;
    }

    private int findLast(char[] chars, int st) {
        for (; st < chars.length; st++) {
            if (chars[st] == ' ') {
                break;
            }
        }
        return st - 1;
    }

    private void reverse(char[] chars, int st, int ed) {
        while (st < ed) {
            char tmp = chars[st];
            chars[st] = chars[ed];
            chars[ed] = tmp;
            st++;
            ed--;
        }
    }

    private int moveBack(char[] chars, int begin, int st, int ed) {
        if (begin == st) {
            return ed;
        }
        while (st <= ed) {
            chars[begin++] = chars[st++];
        }
        return begin - 1;
    }

}
