package tony.leetcode.feature.dynamic_program;

// 494. 目标和
// 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
// 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
// 示例 1:
// 输入: nums: [1, 1, 1, 1, 1], S: 3
// 输出: 5

// 解释:
// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3
// 一共有5种方法让最终目标和为3。

// 注意:
// 数组的长度不会超过20，并且数组中的值全为正数。
// 初始的数组的和不会超过1000。
// 保证返回的最终结果为32位整数。

public class Target_Sum {

    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000){
            return 0;
        }

        // D[i][j] 数组前i个数能够组成和为j的解法数，为了表示负数-1000映射到0
        // 注意是非负整数数组以及和不超过1000，所以直接可以用2001表示
        // 用两个数组即可，因为只会复用前一组内容
        int[][] D = new int[nums.length+1][2001];
        D[0][1000] = 1;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < 2001; j++){
                if (D[i][j] > 0) {
                    D[i+1][j + nums[i]] += D[i][j];
                    D[i+1][j - nums[i]] += D[i][j];
                }
            }
        }

        return D[nums.length][S+1000];
    }
}
