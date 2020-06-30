package tony.sword_to_offer;

// 42. 连续子数组的最大和
// 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
// 求所有子数组的和的最大值。
//
// 要求时间复杂度为O(n)。
//
// 示例1:
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

public class _42_max_subarray {

    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int lastEndMax = nums[0];
        for (int i = 1; i < nums.length;i++) {
            lastEndMax = Math.max(nums[i], lastEndMax + nums[i]);
            max = Math.max(max, lastEndMax);
        }
        return max;
   }

}
