package tony.leetcode.feature.dynamic_program;

// 72. 编辑距离
// 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
//
// 你可以对一个单词进行如下三种操作：
// 插入一个字符
// 删除一个字符
// 替换一个字符
//  
// 示例 1：
// 输入：word1 = "horse", word2 = "ros"
// 输出：3
// 解释：
// horse -> rorse (将 'h' 替换为 'r')
// rorse -> rose (删除 'r')
// rose -> ros (删除 'e')

// 示例 2：
// 输入：word1 = "intention", word2 = "execution"
// 输出：5
// 解释：
// intention -> inention (删除 't')
// inention -> enention (将 'i' 替换为 'e')
// enention -> exention (将 'n' 替换为 'x')
// exention -> exection (将 'n' 替换为 'c')
// exection -> execution (插入 'u')
//  
// 提示：
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成

public class Edit_Distance {

    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n == 0 || m == 0) {
            return Math.max(n, m);
        }

        // DP 数组，D[i][j]表示word1前i个字母和word2前j个字母需要变换几次
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        // 另外一个数组无值时只有做插入或删除字符操作
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 这应该是好理解的
                int n1 = D[i - 1][j] + 1;
                int n2 = D[i][j - 1] + 1;
                int n3 = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    n3 += 1;
                }
                D[i][j] = Math.min(n3, Math.min(n1, n2));
            }
        }
        return D[n][m];
    }

    public int minDistance(String word1, String word2) {
        // 求两个字符串的最大子集长度，这是不对的，求出的结果偏小
        // 比如 moonggg 和 oppggg , 结果并不是 7 - 4 = 3次 而是 4 次
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        int[][] D = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < word2.length(); j++) {
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    D[i + 1][j + 1] = 1 + D[i][j];
                } else {
                    D[i + 1][j + 1] = Math.max(D[i][j + 1], D[i + 1][j]);
                }
            }
        }
        int maxCnt = D[word1.length()][word2.length()];
        return Math.max(word1.length(), word2.length()) - maxCnt;
    }

}
