package tony.sword_to_offer;

// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
// 输入n，打印出s的所有可能的值出现的概率。
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
//
// 示例 1:
// 输入: 1
// 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]

// 示例 2:
// 输入: 2
// 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]

import java.util.Arrays;

public class _60_dice_probability {

    public double[] twoSum(int n) {
        if (n < 1) {
            return null;
        }

        int[][] container = new int[2][6 * n + 1];
        int flag = 0;

        for (int i = 1; i <= 6;i++) {
            container[flag][i] = 1;
        }

        // 骰子个数循环
        for (int k = 2; k <= n; k++) {
            int currentMax = k * 6;

            // 骰子求和范围循环
            for (int i = k; i <= currentMax;i++) {
                container[1 - flag][i] = 0;

                // 取值循环, 基于上一轮 求和 i-1, i-2, i-3, i-4, i-5, i-6
                // 注意要满足条件 i - j >= k - 1, 即上一轮最小值为k - 1, 更小的值是不可能出现这一轮中的
                for (int j = 1; i - j >= k - 1 && j <= 6;j++) {
                    container[1 - flag][i] += container[flag][i - j];
                }
            }
            flag = 1 - flag;
        }

        // 全排列的个数
        double total = Math.pow(6, n);

        double[] result = new double[6 * n - n + 1];

        for (int i = 0; i < result.length;i++) {
            result[i] = container[flag][n + i] / total;
        }

        return result;
    }


    // 递归法
    public double[] twoSum2(int num) {
        if (num < 1) {
            return null;
        }

        int maxSum = num * 6;
        int[] probabilities = new int[maxSum - num + 1];
        for (int i = num; i <= maxSum; i++) {
            probabilities[i - num] = 0;
        }

        probability(num, num, 0, probabilities);

        // 全排列的总数
        double total = Math.pow(6, num);

        double[] result = new double[maxSum - num + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = probabilities[i] / total;
        }

        return result;
    }

    private void probability(int num, int left, int sum, int[] probabilities) {
        if (left == 0) {
            probabilities[sum - num]++;
        } else {
            for (int i = 1; i <= 6; i++) {
                probability(num, left - 1, i + sum, probabilities);
            }
        }
    }

    public static void main(String[] args) {
        double[] doubles = new _60_dice_probability().twoSum2(2);
        System.out.println(Arrays.toString(doubles));
    }

}
