package tony.leetcode.feature.dynamic_program;

// 300. 最长上升子序列
// 给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
// 输入: [10,9,2,5,3,7,101,18]
// 输出: 4
// 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

// 说明:
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。

// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

public class Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        // 以下标为结尾的最长上升子序列长度
        int[] D = new int[nums.length];
        for (int i = 0; i < n;i++){
            int max = 1;
            for (int j = 0; j < i;j++){
                if (nums[i] > nums[j]){
                    max = Math.max(D[j]+1, max);
                }
            }
            D[i] = max;
        }
        int result = 0;
        for (int i = 0; i < n; i++){
            result = Math.max(result, D[i]);
        }
        return result;
    }

    /**
     * dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     * 由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     * 对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     * 1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     * 数组尾部, 并将最长递增序列长度maxL加1
     * 2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     *    此时dp[i-1] < num 使得长度为i+1的递增子序列尾数可以是num
     *    num <= dp[i] 使得dp[i]应该被更新为num
     */
    public int lengthOfLIS2(int[] nums) {
        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;

            // 这里用了< 而不是 <=, 使得lo的最大会被取为maxL（此时dp的有效内容为0 ~ maxL-1）
            while (lo < hi) {
                int mid = lo+(hi-lo)/2;
                if (dp[mid] < num) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            dp[lo] = num;
            if (lo == maxL) {
                maxL++;
            }
        }
        return maxL;
    }
}
