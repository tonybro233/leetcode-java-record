package tony.leetcode.feature.greedy;

// 209. 长度最小的子数组
// 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
// 如果不存在符合条件的连续子数组，返回 0。
//
// 示例:
// 输入: s = 7, nums = [2,3,1,2,4,3]
// 输出: 2
// 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

// 进阶:
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

public class Minimum_Size_Subarray_Sum {

    public int minSubArrayLen2(int s, int[] nums) {
        int k = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum >= s) {
                while (sum - nums[k] >= s) {
                    sum -= nums[k++];
                }
                // 以i结尾的满足条件的最小子数组长度为i - k + 1
                minLen = Math.min(minLen, i - k + 1);
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
