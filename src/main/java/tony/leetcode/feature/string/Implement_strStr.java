package tony.leetcode.feature.string;

// 28
// 实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
// 如果不存在，则返回  -1。
//
// 示例 1:
//
// 输入: haystack = "hello", needle = "ll"
// 输出: 2
// 示例 2:
//
// 输入: haystack = "aaaaa", needle = "bba"
// 输出: -1
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。

public class Implement_strStr {

    // 讲道理应该用kmp算法
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for (int i = 0; i <= source.length - target.length;i++){
            boolean match = true;
            for (int j = 0; j < target.length; j++){
                if (source[i+j] != target[j]){
                    match = false;
                    break;
                }
            }
            if (match){
                return i;
            }
        }

        return -1;
    }
}
