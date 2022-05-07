package tony.leetcode.feature.array.double_pointer;

// 795. 区间子数组个数
// 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空
// 且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
//
// 生成的测试用例保证结果符合 32-bit 整数范围。
//
// 示例 1：
// 输入：nums = [2,1,4,3], left = 2, right = 3
// 输出：3
// 解释：满足条件的三个子数组：[2], [2, 1], [3]

// 示例 2：
// 输入：nums = [2,9,2,5,6], left = 2, right = 8
// 输出：7
//  
//
// 提示：
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
// 0 <= left <= right <= 109

public class Number_of_Subarrays_with_Bounded_Maximum {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int temp = 0, ans = 0;
        // l r 作为左右指针
        for(int r = 0, l = -1; r < nums.length; r++) {
            // 遇到大于最大值的数 左指针移动
            if (nums[r] > right) {
                l = r;
            }

            // 遇到区间范围内的值，因为出现这个值，会增加以这个值为结尾的子数组，子数组个数为 r - l
            if (nums[r] >= left) {
                temp = r - l;
            }
            ans += temp;
        }
        return ans;
    }

}
