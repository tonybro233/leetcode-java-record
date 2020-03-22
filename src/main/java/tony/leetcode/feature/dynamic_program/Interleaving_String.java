package tony.leetcode.feature.dynamic_program;

// 97. 交错字符串
// 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//
// 示例 1:
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// 输出: true

// 示例 2:
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// 输出: false

public class Interleaving_String {

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        // dp[i][j]表示s1[0 ~ i-1]和s2[0 ~ j-1]能否交错组成s3[0 ~ i+j-1]。
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++){
            dp[i+1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for (int i = 0; i < s2.length(); i++){
            dp[0][i+1] = s2.charAt(i) == s3.charAt(i) && dp[0][i];
        }
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length();j++){
                dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) ||
                        (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // 递归超时
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        if ("".equals(s1)){
            return s2.equals(s3);
        }
        if ("".equals(s2)){
            return s1.equals(s3);
        }
        return (s1.charAt(0) == s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1)))
                || (s2.charAt(0) == s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)));
    }
}
