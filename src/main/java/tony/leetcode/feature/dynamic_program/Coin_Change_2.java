package tony.leetcode.feature.dynamic_program;

// 518
// 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
// 假设每一种面额的硬币有无限个。

// 输入: amount = 5, coins = [1, 2, 5]
// 输出: 4
// 解释: 有四种方式可以凑成总金额:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1

public class Coin_Change_2 {

    public int change(int amount, int[] coins) {
        // 背包问题
        int[] D = new int[amount + 1];
        D[0] = 1;

        // 这里顺序不同的组合算同一个组合，所以coin要放在外面
        // 如果不同顺序算不同的组合，那么coin要放里面
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                D[i] += D[i - coin];
            }
        }
        return D[amount];
    }
}
