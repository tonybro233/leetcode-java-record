package tony.sword_to_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 38. 字符串的排列
// 输入一个字符串，打印出该字符串中字符的所有排列。
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
// 示例:
// 输入：s = "abc"
// 输出：["abc","acb","bac","bca","cab","cba"]

public class _38_string_permutation {

    public String[] permutation(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        // 排序，用于去重
        Arrays.sort(chars);
        find(chars, new boolean[chars.length], new StringBuilder(), result);
        return result.toArray(new String[result.size()]);
    }

    private void find(char[] chars, boolean[] mark, StringBuilder current, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!mark[i]) {
                // 去重
                if (i > 0 && chars[i] == chars[i - 1] && !mark[i - 1]) {
                    continue;
                }

                mark[i] = true;
                current.append(chars[i]);
                find(chars, mark, current, result);
                current.deleteCharAt(current.length() - 1);
                mark[i] = false;
            }
        }
    }

}
