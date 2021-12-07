package tony.leetcode.feature.backtracking;

import java.util.ArrayList;
import java.util.List;

// 784.字母大小写全排列
// 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。
// 返回所有可能得到的字符串集合。
//
// 示例：
// 输入：S = "a1b2"
// 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
// 输入：S = "3z4"
// 输出：["3z4", "3Z4"]
//
// 输入：S = "12345"
// 输出：["12345"]
//
// 提示：
// S 的长度不超过12。
// S 仅由数字和字母组成。

public class Letter_Case_Permutation {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        tracking(s, 0, new StringBuilder(), result);
        return result;
    }

    private void tracking(String s, int idx, StringBuilder sb, List<String> result) {
        if (idx == s.length()) {
            result.add(sb.toString());
            return;
        }
        sb.append(s.charAt(idx));
        tracking(s, idx + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        if (Character.isLowerCase(s.charAt(idx))) {
            sb.append(Character.toUpperCase(s.charAt(idx)));
            tracking(s, idx + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        } else if (Character.isUpperCase(s.charAt(idx))) {
            sb.append(Character.toLowerCase(s.charAt(idx)));
            tracking(s, idx + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
