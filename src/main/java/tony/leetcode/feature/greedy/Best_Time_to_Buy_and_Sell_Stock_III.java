package tony.leetcode.feature.greedy;

// 123. 买卖股票的最佳时机 III
// 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
// 示例 1:
// 输入: [3,3,5,0,0,3,1,4]
// 输出: 6
// 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，
//      这笔交易所能获得利润 = 3-0 = 3 。
//      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，
//      这笔交易所能获得利润 = 4-1 = 3 。

// 示例 2:
// 输入: [1,2,3,4,5]
// 输出: 4
// 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出,
//      这笔交易所能获得利润 = 5-1 = 4 。
//      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

// 示例 3:
// 输入: [7,6,4,3,1]
// 输出: 0
// 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。

public class Best_Time_to_Buy_and_Sell_Stock_III {

    // 这个贪心解法真的骚
    public int maxProfit3(int[] prices) {
        if (null == prices || prices.length < 2){
            return 0;
        }

        // b1, b2, s1, s2表示买入卖出时的最大盈利值
        int b1=Integer.MIN_VALUE, b2=Integer.MIN_VALUE;
        int s1=0, s2=0;
        for (int i = 0; i < prices.length; i++){
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, prices[i] + b1);
            b2 = Math.max(b2, prices[i] + s1);
            s2 = Math.max(s2, prices[i] + b2);
        }
        return s2;
    }

    // 枚举比较第一次卖出点
    public int maxProfit2(int[] prices) {
        if (null == prices || prices.length < 2){
            return 0;
        }
        int result = 0;

        int cutMax = 0;
        for (int cut = 0; cut < prices.length; cut++) {
            if (cut < prices.length - 1 && prices[cut] < prices[cut+1] ){
                continue;
            }
            /* 前一段 **/
            int preMin = prices[0];
            int preMax = 0;
            for (int i = 1; i <= cut; i++) {
                preMax = Math.max(preMax, prices[i] - preMin);
                preMin = Math.min(preMin, prices[i]);
            }
            cutMax = preMax;
            /* 后一段 **/
            preMin = prices[cut];
            preMax = 0;
            for (int i = cut + 1; i < prices.length; i++) {
                preMax = Math.max(preMax, prices[i] - preMin);
                preMin = Math.min(preMin, prices[i]);
            }
            cutMax += preMax;
            /* 比较更新 **/
            result = Math.max(cutMax, result);
        }

        return result;
    }

    // 错误，由于限制两次，在递减时可以保持不卖
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2){
            return 0;
        }
        Integer max1 = null, max2 = null, hold = null;
        for (int i = 0; i < prices.length;i++){
            if (null == hold){
                if (i < prices.length - 1 && prices[i+1] > prices[i]){
                    hold = prices[i];
                }
            } else {
                if (i < prices.length - 1){
                    if (prices[i+1] <= prices[i]){
                        int val = prices[i] - hold;
                        if (null == max1 || val > max1){
                            max2 = max1;
                            max1 = val;
                        } else if (null == max2 || val > max2){
                            max1 = val;
                        }
                        hold = null;
                    }
                } else {
                    int val = prices[i] - hold;
                    if (null == max1 || val > max1){
                        max2 = max1;
                        max1 = val;
                    } else if (null == max2 || val > max2){
                        max1 = val;
                    }
                }
            }
        }

        return (max1 != null ? max1 : 0) + (max2 != null ? max2 : 0);
    }

    public static void main(String[] args){
        int i = new Best_Time_to_Buy_and_Sell_Stock_III().maxProfit2(new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }
}
