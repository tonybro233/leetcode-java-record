package tony.leetcode.feature.backtracking;

// 698. 划分为k个相等的子集
// 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//
// 示例 1：
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
// 输出： True
// 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
//  
// 注意:
// 1 <= k <= len(nums) <= 16
// 0 < nums[i] < 10000

import java.util.Arrays;

public class Partition_to_K_Equal_Sum_Subsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        // 为了快速处理单个数字的子集以及剪枝
        Arrays.sort(nums);
        int idx = nums.length - 1;
        if (nums[idx] > target) {
            return false;
        }
        while (idx >= 0 && nums[idx] == target) {
            idx--;
            k--;
        }

        return arrange(nums, idx, new int[k], target);
    }

    private boolean arrange(int[] nums, int idx, int[] buckets, int target) {
        if (idx < 0) {
            return true;
        }

        int cur = nums[idx];
        for (int i = 0;i < buckets.length;i++) {
            // 剪枝，这种情况下该桶不可能配满
            if (target != buckets[i] && target - buckets[i] < nums[0]) {
                return false;
            }

            if (buckets[i] + cur <= target) {
                buckets[i] += cur;
                if (arrange(nums, idx - 1, buckets, target)) {
                    return true;
                }
                buckets[i] -= cur;
            }
        }

        return false;
    }


}
