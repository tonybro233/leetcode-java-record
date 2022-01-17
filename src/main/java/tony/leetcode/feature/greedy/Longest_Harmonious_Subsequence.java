package tony.leetcode.feature.greedy;

import java.util.Arrays;

// 594. 最长和谐子序列
// 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
// 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
//
// 示例 1:
// 输入: [1,3,2,2,5,2,3,7]
// 输出: 5
// 原因: 最长的和谐数组是：[3,2,2,2,3].

// 说明: 输入的数组长度最大不超过20,000.

public class Longest_Harmonious_Subsequence {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }

    public int findLHS2(int[] nums) {
        Arrays.sort(nums);
        int idx = 0;
        int lastVal = nums[0];
        int nextIdx = getNext(idx, nums);
        int c1 = nextIdx - idx, c2 = 0;
        idx = nextIdx;
        int result = 0;
        while (idx < nums.length) {
            nextIdx = getNext(idx, nums);
            c2 = nextIdx - idx;
            if (nums[nextIdx - 1] - lastVal == 1) {
                result = Math.max(result, c2 + c1);
            }
            c1 = c2;
            lastVal = nums[nextIdx - 1];
            idx = nextIdx;
        }
        return result;
    }

    private int getNext(int idx, int[] nums) {
        int val = nums[idx++];
        for (; idx < nums.length; idx++) {
            if (nums[idx] != val) {
                break;
            }
        }
        return idx;
    }

}
