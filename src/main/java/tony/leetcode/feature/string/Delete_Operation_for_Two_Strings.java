package tony.leetcode.feature.string;

// 583. 两个字符串的删除操作
// 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
// 每步可以删除任意一个字符串中的一个字符。
//
// 示例 1:
// 输入: "sea", "eat"
// 输出: 2
// 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"

// 说明:
// 给定单词的长度不超过500。
// 给定单词中的字符只含有小写字母。

public class Delete_Operation_for_Two_Strings {

    // LCS(最长公共子序列)，动态规划
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray(), c2 = word2.toCharArray();
        int n1 = c1.length, n2 = c2.length;
        int[][] D = new int[n1+1][n2+1];

        for (int j = 1; j <= n2;j++){
            for (int i = 1; i <= n1;i++){
                if (c1[i-1] == c2[j-1]){
                    D[i][j] = D[i-1][j-1]+1;
                } else {
                    D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
                }
            }
        }

        return n1 - D[n1][n2] + n2 - D[n1][n2];
    }
}
