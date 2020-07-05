package tony.sword_to_offer;

// 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
// 示例 1:
// 输入: "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

// 示例 2:
// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

import java.util.HashMap;
import java.util.Map;

public class _48_longest_unique_substring {

    public int lengthOfLongestSubstring(String s) {
        if (null == s) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int max = 1;
        int bottom = 0;
        int count = 1;
        int len = s.length();

        for (int i = 1; i < len;i++) {
            Integer pos = map.get(s.charAt(i));
            if (null == pos || pos < bottom) {
                count++;
                max = Math.max(max, count);
            } else {
                count = i - pos;
                bottom = pos + 1;
            }
            map.put(s.charAt(i), i);
        }

        return max;
    }

}
