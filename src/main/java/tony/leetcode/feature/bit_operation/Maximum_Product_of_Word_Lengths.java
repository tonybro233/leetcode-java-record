package tony.leetcode.feature.bit_operation;

// 318. 最大单词长度乘积
// 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
// 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。
// 如果不存在这样的两个单词，返回 0。
//
// 示例 1:
// 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
// 输出: 16
// 解释: 这两个单词为 "abcw", "xtfn"。

// 示例 2:
// 输入: ["a","ab","abc","d","cd","bcd","abcd"]
// 输出: 4
// 解释: 这两个单词为 "ab", "cd"。

// 示例 3:
// 输入: ["a","aa","aaa","aaaa"]
// 输出: 0
// 解释: 不存在这样的两个单词。

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Maximum_Product_of_Word_Lengths {

    // 使用位运算，两个解法道理是一样的，每个字母一个槽，相比使用数组记录，位运算更快
    // 记住32比26大这个性质
    public int maxProduct2(String[] words) {
        int n = words.length;
        int[] hash = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                hash[i] |= 1 << (c-'a');
            }
        }

        for(int i = 0; i < n-1; ++i) {
            for(int j = i+1; j < n; ++j) {
                if ((hash[i] & hash[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }

    public int maxProduct(String[] words) {
        int result = 0;
        int[] judge = new int[26];
        for (int i = 0; i < words.length - 1;i++){
            for (int ii = 0; ii < words[i].length(); ii++){
                judge[words[i].charAt(ii) - 'a']++;
            }

            for (int j = i+1; j < words.length; j++){
                boolean match = true;
                for (int jj = 0; jj < words[j].length(); jj++){
                    if (judge[words[j].charAt(jj) - 'a'] > 0){
                        match = false;
                        break;
                    }
                }
                if (match){
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }

            Arrays.fill(judge, 0);
        }

        return result;
    }
}
