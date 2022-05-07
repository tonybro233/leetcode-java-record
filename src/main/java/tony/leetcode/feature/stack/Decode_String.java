package tony.leetcode.feature.stack;

import java.util.*;

// 394. 字符串解码
// 给定一个经过编码的字符串，返回它解码后的字符串。
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
// 示例:
// s = "3[a]2[bc]", 返回 "aaabcbc".
// s = "3[a2[c]]", 返回 "accaccacc".
// s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".

public class Decode_String {

    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> bufferStack = new LinkedList<>();
        StringBuilder buffer = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            } else if ('[' == s.charAt(i)) {
                numStack.addLast(num);
                num = 0;
                bufferStack.addLast(buffer);
                buffer = new StringBuilder();
            } else if (']' == s.charAt(i)) {
                String str = buffer.toString();
                num = numStack.pollLast();
                buffer = bufferStack.pollLast();
                while (num > 0) {
                    num--;
                    buffer.append(str);
                }
            } else {
                buffer.append(s.charAt(i));
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String string = new Decode_String().decodeString("3[a2[c]]dd");
        System.out.println(string);
    }
}
