package tony.leetcode.feature.dynamic_program;

public class Ones_and_Zeroes {

    // 474
    // 在计算机界中，我们总是追求用有限的资源获取最大的收益。
    // 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
    // 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。
    // 每个 0 和 1 至多被使用一次。
    //
    // 注意:
    // 给定 0 和 1 的数量都不会超过 100。
    // 给定字符串数组的长度不会超过 600。

    // 输入: Array = {"10", "0", "1"}, m = 1, n = 1
    // 输出: 2
    // 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1"。

    /**
     * 想不出来，dp的变种
     * m,n作为求dp的循环上限，dp二维数组是有很多'多余值'的
     * D[i][j]代表i个0和j个1能够对当前的字符串数组下能拼出的最大数组量
     * dp公式又是需要循环求值，根本想不到
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (String s : strs) {
            int zero = 0, one = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m; i > zero - 1; i--) {
                for (int j = n; j > one - 1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
