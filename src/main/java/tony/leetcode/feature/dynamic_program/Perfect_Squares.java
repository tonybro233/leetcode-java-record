package tony.leetcode.feature.dynamic_program;

// 279. 完全平方数
// 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
// 你需要让组成和的完全平方数的个数最少。
//
// 示例 1:
// 输入: n = 12
// 输出: 3
// 解释: 12 = 4 + 4 + 4.

// 示例 2:
// 输入: n = 13
// 输出: 2
// 解释: 13 = 4 + 9.

public class Perfect_Squares {

    public int numSquares(int n) {
        int[] D = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 从本身开始减去完全平方数
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, D[i - j * j] + 1);
            }
            D[i] = min;
        }
        return D[n];
    }

    // 如果n很大则需要用这种
    public int numSquares2(int n) {
        int mincount = Integer.MAX_VALUE;
        for (int i = (int) Math.sqrt(n); i > 1; i--) {
            int value = n - i * i;
            int count = 1;
            while (value > 0) {
                // 无论如何都可以用1来填平，因此可以这么做
                int residual = (int) Math.sqrt(value);
                value -= residual * residual;
                count++;
            }
            if (count < mincount) {
                mincount = count;
                if (count == 1) {
                    return 1;
                }
            }
        }
        return mincount;
    }

}
