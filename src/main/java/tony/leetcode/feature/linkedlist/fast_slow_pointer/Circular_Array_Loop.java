package tony.leetcode.feature.linkedlist.fast_slow_pointer;

// 457. 环形数组是否存在循环
// 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i
// 的角色应该向前或向后移动的下标个数：
//
// 如果 nums[i] 是正数，向前 移动 nums[i] 步
// 如果 nums[i] 是负数，向后 移动 nums[i] 步
// 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，
// 而第一个元素向后移动一步会到达最后一个元素。
//
// 数组中的 循环 由长度为 k 的下标序列 seq ：
//
// 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
// 所有 nums[seq[j]] 应当不是 全正 就是 全负
// k > 1
// 如果 nums 中存在循环，返回 true ；否则，返回 false 。
//
//  示例 1：
// 输入：nums = [2,-1,1,2,2]
// 输出：true
// 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。

// 示例 2：
// 输入：nums = [-1,2]
// 输出：false
// 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。

// 示例 3:
// 输入：nums = [-2,1,-1,-2,-2]
// 输出：false
// 解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
// 所有 nums[seq[j]] 应当不是全正就是全负。
//
// 提示：
// 1 <= nums.length <= 5000
// -1000 <= nums[i] <= 1000
// nums[i] != 0

// 进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？

public class Circular_Array_Loop {


    // 快慢指针
    public boolean circularArrayLoop2(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i, fast = next(nums, i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (next(nums, slow) != slow) {
                        return true;
                    } else {
                        break;
                    }
                }

                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }

            // 加快速度，把不可能的数都置为0
            int pointer = i;
            while (nums[pointer] * nums[next(nums, pointer)] > 0) {
                int tmp = pointer;
                pointer = next(nums, pointer);
                nums[tmp] = 0;
            }
        }

        return false;
    }

    private int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中
    }

    // 不对
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int len = nums.length;
        int[] pos = new int[len];
        int[] neg = new int[len];
        int posGood = 0, negGood = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                neg[i]++;
                if (i >= -nums[i]) {
                    neg[i + nums[i]]++;
                } else {
                    neg[len - (-nums[i] - i) % len]++;
                }
            } else {
                pos[i]++;
                if (i + nums[i] < len) {
                    pos[i + nums[i]]++;
                } else {
                    pos[(i + nums[i] - len) % len]++;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (pos[i] > 1) {
                posGood++;
            }
            if (neg[i] > 1) {
                negGood++;
            }
        }

        return posGood > 1 || negGood > 1;
    }

    public static void main(String[] args) {
        boolean res = new Circular_Array_Loop().circularArrayLoop2(new int[]{2,2,2,2,2,4,7});
        System.out.println(res);
    }

}
