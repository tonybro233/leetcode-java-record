package tony.leetcode.feature.greedy;

// 45. 跳跃游戏 II

// 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 假设你总是可以到达数组的最后一个位置。

// 示例 1:
// 输入: nums = [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

// 示例 2:
// 输入: nums = [2,3,0,1,4]
// 输出: 2

// 提示:
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000

public class Jump_Game_II {

    public int jump3(int[] nums) {
        int step = 0;
        int len = nums.length;
        int tempMax = 0; // 当前步数下能走到的最远距离
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == tempMax) {
                tempMax = max;
                step++;
                if (max >= len - 1) {
                    break;
                }
            }
        }
        return step;
    }

    // 错误解法
    // 错误例子：1 2 1 1 1
    public int jump2(int[] nums) {
        int step = 0;
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            step++;
            max = Math.max(max, i + nums[i]);
            if (max >= len - 1) {
                break;
            }
        }

        return step;
    }

    // 直观的动态规划
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int[] mark = new int[len];
        int limit = len - 1;
        for (int i = 0; i < len - 1; i++) {
            int val = mark[i] + 1;
            if (mark[limit] > 0 && val >= mark[limit]) {
                continue;
            }
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                if (mark[j] == 0 || mark[j] > val) {
                    mark[j] = val;
                }
            }
        }
        return mark[limit];
    }

}
