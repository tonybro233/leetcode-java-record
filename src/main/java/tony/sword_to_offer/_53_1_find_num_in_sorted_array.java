package tony.sword_to_offer;

// 53 - I. 在排序数组中查找数字
// 统计一个数字在排序数组中出现的次数。
//
// 示例 1:
// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: 2

// 示例 2:
// 输入: nums = [5,7,7,8,8,10], target = 6
// 输出: 0

public class _53_1_find_num_in_sorted_array {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midVal = nums[mid];

            if (midVal == target) {
                if (nums[lo] < midVal) {
                    lo++;
                }
                if (nums[hi] > midVal) {
                    hi--;
                }
                if (nums[lo] == target && nums[hi] == target) {
                    return hi - lo + 1;
                }
            } else if (midVal < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return 0;
    }

}
