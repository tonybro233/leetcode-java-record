package tony.leetcode.level.hard;

// 41. 缺失的第一个正数
// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//
// 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//  
// 示例 1：
// 输入：nums = [1,2,0]
// 输出：3

// 示例 2：
// 输入：nums = [3,4,-1,1]
// 输出：2

// 示例 3：
// 输入：nums = [7,8,9,11,12]
// 输出：1
//
// 提示：
// 1 <= nums.length <= 5 * 105
// -231 <= nums[i] <= 231 - 1

public class First_Missing_Positive {

    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        // 把不符合的非正整数都置为最大的可能值 len + 1
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }

        // 哈希标记
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len && nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }


    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 交换法
            // 关键在于nums[i] 对应的位置是 nums[i] - 1
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                exch(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



}
