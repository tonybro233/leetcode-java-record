package tony.sword_to_offer;

// 05. 替换空格
// 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

import java.util.Arrays;

public class _05_replace_blank {

    // 原题的目标是原地修改，但是如果输入为String，是无法做到的
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int blankCount = 0;
        for (char c : chars) {
            if (c == ' ') {
                blankCount++;
            }
        }
        if (blankCount == 0) {
            return s;
        }

        char[] copy = Arrays.copyOf(chars, chars.length + 2 * blankCount);
        int p1 = copy.length - 1, p2 = chars.length - 1;

        while (p2 >= 0) {
            if (chars[p2] == ' ') {
                copy[p1--] = '0';
                copy[p1--] = '2';
                copy[p1--] = '%';
            } else {
                copy[p1--] = chars[p2];
            }
            p2--;
        }

        return new String(copy);
    }

}
