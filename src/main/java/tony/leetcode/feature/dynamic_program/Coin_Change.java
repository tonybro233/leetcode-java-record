package tony.leetcode.feature.dynamic_program;

// 322. 零钱兑换
//
// 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
// 如果没有任何一种硬币组合能组成总金额，返回 -1。
//
// 示例 1:
// 输入: coins = [1, 2, 5], amount = 11
// 输出: 3
// 解释: 11 = 5 + 5 + 1

// 示例 2:
// 输入: coins = [2], amount = 3
// 输出: -1

// 说明:
// 你可以认为每种硬币的数量是无限的。

import java.util.Arrays;

public class Coin_Change {

    public int coinChange(int[] coins, int amount) {
        int[] D = new int[amount+1];
        Arrays.fill(D, -1);
        D[0] = 0;
        for (int i = 0;i < amount;i++){
            for (int coin : coins){
                long sum = (long)i + (long)coin; // 相加的解法会出现越界的情况
                if (D[i] < 0 || sum > amount){
                    continue;
                }
                if (D[i+coin] < 0 ){
                    D[i+coin] = D[i]+1;
                } else {
                    D[i+coin] = Math.min(D[i]+1, D[i+coin]);
                }
            }
        }

        return D[amount];
    }

    // 同样的思路，相减的解法
    public int coinChange2(int[] coins, int amount){
        int[] D = new int[amount+1];
        Arrays.fill(D, amount+1);
        for (int i = 0; i <= amount;i++){
            for (int coin : coins){
                if (i - coin < 0){
                    continue;
                }
                D[i] = Math.min(D[i], D[i-coin]+1);
            }
        }
        return D[amount] == amount + 1 ? -1 : D[amount];
    }

    public static void main(String[] args){
        int i = new Coin_Change().coinChange(new int[]{1, 2147483647}, 2);
        System.out.println(i);
    }
}
