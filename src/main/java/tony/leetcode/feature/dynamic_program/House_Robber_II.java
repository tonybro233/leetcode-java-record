package tony.leetcode.feature.dynamic_program;

// 213 打家劫舍 II
// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
// 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
// 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

// 示例 1:
// 输入: [2,3,2]
// 输出: 3
// 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

public class House_Robber_II {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 抢第一间房，不可以抢最后一间，转移方程同 打家劫舍I
        int[] val = new int[n];
        val[0] = nums[0];
        val[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++){
            val[i] = Math.max(val[i - 2] + nums[i], val[i - 1]);
        }
        int max1 = val[n-2];

        // 抢最后一间，不可以抢第一间
        val = new int[n];
        val[1] = nums[1];
        val[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n;i++){
            val[i] = Math.max(val[i - 2] + nums[i], val[i - 1]);
        }
        int max2 = val[n-1];

        return Math.max(max1, max2);
    }
}
