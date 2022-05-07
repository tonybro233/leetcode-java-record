package tony.leetcode.feature.string;

// 76. 最小覆盖子串
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。
//  
// 示例 1：
// 输入：s = "ADOBECODEBANC", t = "ABC"
// 输出："BANC"

// 示例 2：
// 输入：s = "a", t = "a"
// 输出："a"

// 示例 3:
// 输入: s = "a", t = "aa"
// 输出: ""
// 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
// 因此没有符合条件的子字符串，返回空字符串。
//  
// 提示：
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {

    public String minWindow2(String s, String t) {
        // 使用数组来实现
        int[] array = new int[128];
        // 当前需要的非重复字母个数
        int letterCount = 0;
        // 保证不需要的字母不会递增到0，需要的字母初始到对应的数量
        Arrays.fill(array, -t.length());
        for (int i = 0; i < t.length(); i++) {
            if (array[t.charAt(i)] == -t.length()) {
                array[t.charAt(i)] = 0;
                letterCount++;
            }
            array[t.charAt(i)]++;
        }
        int resLeft = 0, resRight = -1, min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            array[rc]--;
            // 需要的字母满足条件
            if (array[rc] == 0) {
                letterCount--;
            }
            // 缩减左边界
            while (letterCount == 0) {
                if (right - left + 1 < min) {
                    resLeft = left;
                    resRight = right;
                    min = right - left + 1;
                }
                array[s.charAt(left)]++;
                // 需要的字母出现短缺
                if (array[s.charAt(left)] == 1) {
                    letterCount++;
                }
                left++;
            }
            right++;
        }
        return s.substring(resLeft, resRight + 1);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> source = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            source.compute(t.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }
        int minIdx = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> judge = new HashMap<>();
        int i = 0, j = 0;
        if (source.containsKey(s.charAt(i))) {
            judge.put(s.charAt(i), 1);
        }
        while (true) {
            if (includeBy(source, judge)) {
                if (j - i + 1 < minLen) {
                    minIdx = i;
                    minLen = j - i + 1;
                }
                judge.compute(s.charAt(i++), (k, v) -> {
                    if (v != null) {
                        v--;
                    }
                    return v;
                });
                continue;
            }

            j++;
            if (j >= s.length()) {
                break;
            }
            if (source.containsKey(s.charAt(j))) {
                judge.compute(s.charAt(j), (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return ++v;
                });
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minIdx, minIdx + minLen);
        }
    }

    private boolean includeBy(Map<Character, Integer> source, Map<Character, Integer> target) {
        for (Map.Entry<Character, Integer> entry : source.entrySet()) {
            if (target.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
