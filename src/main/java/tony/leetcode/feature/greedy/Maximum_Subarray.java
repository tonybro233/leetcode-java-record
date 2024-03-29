package tony.leetcode.feature.greedy;

// 53. 最大子数组和
// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

// 进阶:
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

public class Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        // 维护以前一项为结尾的连续数组最大和
        int lastMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lastMax = Math.max(nums[i], lastMax + nums[i]);
            max = Math.max(max, lastMax);
        }
        return max;
    }
}
