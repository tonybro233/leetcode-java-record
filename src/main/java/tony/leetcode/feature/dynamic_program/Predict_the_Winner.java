package tony.leetcode.feature.dynamic_program;

// 486
// 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，
// 随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。
// 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。
// 直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
//
// 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。

// 输入: [1, 5, 2]
// 输出: False
// 输入: [1, 5, 233, 7]
// 输出: True

// 1 <= 给定的数组长度 <= 20.
// 数组里所有分数都为非负数且不会大于10000000。
// 如果最终两个玩家的分数相等，那么玩家1仍为赢家。

public class Predict_the_Winner {

    /*
        动态规划
        D[i][j]表示数组内i~j区间中按照规则能够取得的最大分数
        sum[i][i]表示数组内i~j区间中的总和
        那么D[i][j] = max(sum[i+1][j] - D[i+1][j] + nums[i], sum[i][j-1] - D[i][j-1] + nums[j])
        而D[i][i] = nums[i]
     */

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] D = new int[n][n];
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 0 ; i < n; i++){
            D[i][i] = nums[i];
            if (i > 0){
                sum[i] = sum[i-1]+nums[i];
            }
        }

        // 从i = n - 2, j = n - 1开始
        for (int i = n - 2; i >= 0; i--){
            int val = i == 0 ? 0 : sum[i-1];
            for (int j = i+1; j < n; j++){
                D[i][j] = Math.max(sum[j] - val - D[i+1][j], sum[j] - val - D[i][j-1]);
            }
        }

        return D[0][n-1] >= (sum[n-1] - D[0][n-1]);
    }
}
