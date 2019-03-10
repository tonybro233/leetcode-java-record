package tony.leetcode.feature.string;

// 395. 至少有K个重复字符的最长子串
// 找到给定字符串（由小写字符组成）中的最长子串 T ，要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
//
// 示例 1:
// 输入:
// s = "aaabb", k = 3
// 输出:
// 3
// 最长子串为 "aaa" ，其中 'a' 重复了 3 次。

// 示例 2:
// 输入:
// s = "ababbc", k = 2
// 输出:
// 5
// 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。

public class Longest_Substring_with_At_Least_K_Repeating_Characters {

    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || k == 1) {
            return s.length();
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }

        // 全部字符出现次数都大于k则直接返回
        boolean allGood = true;
        for (int i = 0; i < s.length(); i++){
            if (count[s.charAt(i) - 'a'] < k){
                allGood = false;
                break;
            }
        }
        if (allGood){
            return s.length();
        }

        int ret = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++ ) {
            if (count[s.charAt(i) - 'a'] < k) {
                // 发现不满足，则计算前面的一段子串
                ret = Math.max(ret, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        // 计算最后一段子串并比较
        return Math.max(ret, longestSubstring(s.substring(start), k));
    }
}
