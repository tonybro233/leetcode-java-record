package tony.leetcode.feature.dynamic_program;

// 740. 删除与获得点数
// 给定一个整数数组 nums ，你可以对它进行一些操作。
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
// 之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//
// 示例 1:
// 输入: nums = [3, 4, 2]
// 输出: 6
// 解释:
// 删除 4 来获得 4 个点数，因此 3 也被删除。
// 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。

// 示例 2:
// 输入: nums = [2, 2, 3, 3, 3, 4]
// 输出: 9
// 解释:
// 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
// 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
// 总共获得 9 个点数。

// 注意:
// nums的长度最大为20000。
// 每个整数nums[i]的大小都在[1, 10000]范围内。

import java.util.Arrays;

public class Delete_and_Earn {

    public int deleteAndEarn2(int[] nums) {
        // 首先要想到对数组排序不会对结果造成改变
        Arrays.sort(nums);

        int current = -1;
        int takeMax = 0; // 表示当前值作为最大值时，是获得点数时的最大点数，一个值被获取时，所有相同值都可以被获取
        int deleteMax = 0; // 表示当前值作为最大值时，是被删掉时的最大点数
        int swap = 0, lastPos = 0;

        for (int i = 0; i < nums.length; ) {
            lastPos = getLastPos(nums, i);
            if (nums[i] == current + 1) {
                swap = deleteMax;
                // 例如在计算 2 2 3 4 6 时 4的deletemax应该是4而不是3
                deleteMax = Math.max(deleteMax, takeMax);
                takeMax = swap + nums[i] * (lastPos - i + 1);
            } else {
                deleteMax = Math.max(deleteMax, takeMax);
                takeMax = deleteMax + nums[i] * (lastPos - i + 1);
            }
            current = nums[i];
            i = lastPos + 1;
        }

        return Math.max(deleteMax, takeMax);
    }

    private int getLastPos(int[] nums, int begin) {
        int val = nums[begin];
        while (begin + 1 < nums.length && nums[begin + 1] == val) {
            begin++;
        }
        return begin;
    }

    public static void main(String[] args) {
        int i = new Delete_and_Earn().deleteAndEarn2(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6});
        System.out.println(i);
    }

}
