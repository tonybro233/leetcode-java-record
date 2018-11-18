package tony.leetcode.feature.dynamic_program;

public class Coin_Change_2 {

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


    /**
     * 动态规划：
     * D[i] = D[i-coins[0]] + D[i-coins[1]] + ... + D[i-coins[n-1]]
     * D[0] = 1
     */
    public int change(int amount, int[] coins) {
        int[] D = new int[amount+1];
        D[0] = 1;

        for (int coin : coins){
            for (int i = coin; i < amount+1;i++){
                D[i] += D[i-coin];
            }
        }
        return D[amount];
    }
}
