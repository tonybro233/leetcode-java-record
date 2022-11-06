package tony.leetcode.feature.greedy;

// 135. 分发糖果
// n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
//
// 你需要按照以下要求，给这些孩子分发糖果：
// 每个孩子至少分配到 1 个糖果。
// 相邻两个孩子评分更高的孩子会获得更多的糖果。
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
//
// 示例 1：
// 输入：ratings = [1,0,2]
// 输出：5
// 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。

// 示例 2：
// 输入：ratings = [1,2,2]
// 输出：4
// 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
//  
// 提示：
// n == ratings.length
// 1 <= n <= 2 * 104
// 0 <= ratings[i] <= 2 * 104

public class Candy {

    public int candy(int[] ratings) {
        // 将条件分割为两个: 比左节点大、比右节点大，然后取最大值
        // 需要想到叠加后不影响最终结果以及出现非递增时要归1处理
        int[] r1 = new int[ratings.length];
        int[] r2 = new int[ratings.length];
        r1[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                r1[i] = r1[i - 1] + 1;
            } else {
                // 注意这里是归1处理
                r1[i] = 1;
            }
        }
        r2[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                r2[i] = r2[i + 1] + 1;
            } else {
                r2[i] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < ratings.length;i++) {
            result += Math.max(r1[i], r2[i]);
        }
        return result;
    }

}
