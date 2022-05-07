package tony.leetcode.feature.hash;

import java.util.*;

// 3 无重复字符的最长子串
// 给定一个字符串，找出不含有重复字符的最长子串的长度。

// 输入: "abcabcbb"
// 输出: 3
// 解释: 无重复字符的最长子串是 "abc"，其长度为 3。

// 输入: "pwwkew"
// 输出: 3
// 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
// 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。

public class Longest_Substring_Without_Repeating_Characters {

    // 维护当前无重复子串的尾部位置，读取下一个字符时，如果有重复，则砍掉重复数字之前的内容。没有重复则更新最大值
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int count = 0;
        int bottom = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char ea = chars[i];
            Integer index = map.get(ea);
            if (null == index || index < bottom) {
                count++;
                max = Math.max(max, count);
            } else {
                count = i - index;
                bottom = index + 1;
            }
            map.put(ea, i);
        }

        return max;
    }

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters go = new Longest_Substring_Without_Repeating_Characters();
        int size = go.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(size);
    }
}
