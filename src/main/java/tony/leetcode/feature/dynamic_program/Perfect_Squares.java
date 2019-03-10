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
        if (n <= 1){
            return 1;
        }
        int[] val = new int[n+1];
        val[0] = 0;
        val[1] = 1;
        for (int i = 2; i <= n;i++){
            int min = Integer.MAX_VALUE;
            // 从本身开始减去完全平方数
            for (int j = 1; j*j <= i; j++){
                min = Math.min(min, 1 + val[i-j*j]);
            }
            val[i] = min;
        }
        return val[n];
    }

}
