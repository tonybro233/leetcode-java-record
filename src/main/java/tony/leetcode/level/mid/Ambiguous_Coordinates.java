package tony.leetcode.level.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 816. 模糊坐标
// 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，
// 得到一个字符串S。返回所有可能的原始字符串到一个列表中。
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00",
// "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，
// 所以也不会出现“.1”形式的数字。
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
//
//
// 示例 1:
// 输入: "(123)"
// 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
//
// 示例 2:
// 输入: "(00011)"
// 输出:  ["(0.001, 1)", "(0, 0.011)"]
// 解释:
// 0.0, 00, 0001 或 00.01 是不被允许的。
//
// 示例 3:
// 输入: "(0123)"
// 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12,
// 3)"]
//
// 示例 4:
// 输入: "(100)"
// 输出: [(10, 0)]
// 解释:
// 1.0 是不被允许的。
//
//
// 提示:
// 4 <= S.length <= 12.
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。

public class Ambiguous_Coordinates {

    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s.length() - 2; i++) {
            String s1 = s.substring(1, i + 1);
            String s2 = s.substring(i + 1, s.length() - 1);
            if (twoOrMoreZeros(s1)) {
                i = nextNonZero(s, i + 1) - 1;
                continue;
            }

            if (twoOrMoreZeros(s2)) {
                i = s.length() - 4;
                continue;
            }

            List<String> part1 = split(s1);
            List<String> part2 = split(s2);
            for (String p1 : part1) {
                for (String p2 : part2) {
                    result.add("(" + p1 + ", " + p2 + ")");
                }
            }
        }

        return result;
    }

    private boolean twoOrMoreZeros(String s) {
        if (s.length() <= 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private int nextNonZero(String s, int stIdx) {
        for (int i = stIdx; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return i;
            }
        }
        return s.length();
    }

    private List<String> split(String s) {
        if (s.length() == 1) {
            return Collections.singletonList(s);
        }
        if (s.charAt(s.length() - 1) == '0') {
            if (s.charAt(0) == '0') {
                return Collections.emptyList();
            }
            return Collections.singletonList(s);
        }
        if (s.charAt(0) == '0') {
            return Collections.singletonList("0." + s.substring(1));
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            res.add(s.substring(0, i) + "." + s.substring(i));
        }
        res.add(s);
        return res;
    }

    public static void main(String[] args) {
        Ambiguous_Coordinates solution = new Ambiguous_Coordinates();
        List<String> res = solution.ambiguousCoordinates("(0010)");
        System.out.println(res);
    }

}
