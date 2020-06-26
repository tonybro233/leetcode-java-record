package tony.sword_to_offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 03. 数组中重复的数字
//
// 找出数组中重复的数字。
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
// 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
// 请找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
// [2, 3, 1, 0, 2, 5, 3]
// 输出：2 或 3
//
// 限制：
// 2 <= n <= 100000

public class _03_repeat_number {

    // 最简单的hash
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        throw new IllegalStateException("No duplication found");
    }

    // 空间限制，原地排序
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1;i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        throw new IllegalStateException("No duplication found");
    }

    // 空间限制，原地归位
    public int findRepeatNumber3(int[] nums) {
        for (int i = 0;i < nums.length;i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] != nums[i]) {
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                } else {
                    return nums[i];
                }
            }
        }

        throw new IllegalStateException("No duplication found");
    }

    // 空间O(1), 不可修改数组, 二分
    // 不适用于上述题目的条件，需要满足数字的范围要比数组长度小
    // 不能使用注释的写法是因为 mid = (lo + hi) / 2 这一步的使得 lo <= mid < hi
    // 在lo = hi - 1的情况下mid = lo，那么统计mid~hi的数量是没有意义的，等于还是统计了整个区间的数字
    public int findRepeatNumber4(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = 0, count = 0;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            count = countRange(nums, lo, mid);

            // count = countRange(nums, mid, hi);

            if (lo == hi) {
                if (count > 1) {
                    return lo;
                } else {
                    break;
                }
            }

            if (count > mid - lo + 1) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

            // if (count > hi - mid + 1) {
            //     lo = mid;
            // } else {
            //     hi = mid - 1;
            // }
        }

        throw new IllegalStateException("No duplication found");
    }

    private int countRange(int[] nums, int lo, int hi) {
        int count = 0;
        for (int num : nums) {
            if (num >= lo && num <= hi) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(1 / 2);
        int i = new _03_repeat_number().findRepeatNumber4(new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9});
        System.out.println(i);
    }

}
