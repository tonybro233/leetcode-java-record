package tony.leetcode.feature.dynamic_program;

// 5
// 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

// 输入: "babad"
// 输出: "bab"
// 注意: "aba"也是一个有效答案。

public class Longest_Palindromic_Substring {


    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        // D[i,j] 表示从i到j的范围是否是一个回文串
        boolean[][] D = new boolean[n][n];

        int maxlength = 0;
        int start = 0;

        // 初始化D[i,i]
        for (int i = 0; i < n; i++) {
            D[i][i] = true;
            if (i < n - 1 && chars[i] == chars[i + 1]) {
                D[i][i + 1] = true;
                maxlength = 2;
                start = i;
            }
            if (maxlength < 2) {
                start = i;
                maxlength = 1;
            }
        }

        // 使用上述结果可以dp出子串长度为 3 ~ n 的子串
        for (int strlen = 3; strlen <= n; strlen++) {
            for (int i = 0; i <= n - strlen; i++) {
                int j = i + strlen - 1; // 子串结束的位置
                if (D[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    D[i][j] = true;
                    maxlength = strlen;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxlength);
    }


    private int lo, maxLen;

    /**
     * 直接遍历数组，获取每个元素为中心的最长回文串，考虑bab 和 baab两种情况
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  // .. b a b ..
            extendPalindrome(s, i, i + 1); //.. b aa b ..
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        Longest_Palindromic_Substring go = new Longest_Palindromic_Substring();
        //int size = go.lengthOfLongestSubstring("tmmzuxt");
        //System.out.println(size);
    }
}
