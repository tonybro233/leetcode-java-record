package tony.leetcode.feature.greedy;

import java.util.HashMap;
import java.util.Map;

// 424. 替换后的最长重复字符
// 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
// 在执行上述操作后，找到包含重复字母的最长子串的长度。
//
// 注意:
// 字符串长度 和 k 不会超过 104。
//
// 示例 1:
// 输入:
// s = "ABAB", k = 2
// 输出: 4
// 解释:
// 用两个'A'替换为两个'B',反之亦然。

// 示例 2:
// 输入:
// s = "AABABBA", k = 1
// 输出: 4
// 解释:
// 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
// 子串 "BBBB" 有最长重复字母, 答案为 4。

public class Longest_Repeating_Character_Replacement {

    public int characterReplacement3(String s, int k) {
        // 使用数组来统计区间内的计数
        int[] num = new int[26];
        int n = s.length();
        int maxCount = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, num[s.charAt(right) - 'A']);
            // 保证区间长度不会递减
            if (right - left + 1 - maxCount > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public int characterReplacement2(String s, int k) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }

        // 维护一个区间，保证“优势字符”之外的其他字符个数不大于k
        int max = 0;
        int p1 = 0, p2 = 0;

        int[] map = new int[26]; // 优化为使用数组存储
        int maxCur = 0;

        while (p2 < chars.length) {
            // 最大值一定出现在新入区间的字母上
            maxCur = Math.max(maxCur, ++map[chars[p2] - 'A']);
            p2 += 1;
            while (p2 - p1 - maxCur > k) {
                // 不满足说明需要舍弃尾部
                map[chars[p1++] - 'A']--;
            }
            max = Math.max(max, p2 - p1);
        }

        return max;
    }

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }

        // 维护一个区间，保证“优势字符”之外的其他字符个数不大于k
        int max = 0;
        int p1 = 0, p2 = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (p2 < chars.length) {
            Integer c = map.getOrDefault(chars[p2], 0) + 1;
            map.put(chars[p2], c);
            p2 += 1;
            while (p2 - p1 - getMaxVal(map) > k) {
                // 不满足说明需要舍弃尾部
                map.put(chars[p1], map.get(chars[p1]) - 1);
                p1 += 1;
            }
            max = Math.max(max, p2 - p1);
        }

        return max;
    }

    private int getMaxVal(Map<Character, Integer> map) {
        int max = 0;
        for (int ea : map.values()) {
            max = Math.max(max, ea);
        }
        return max;
    }
}
