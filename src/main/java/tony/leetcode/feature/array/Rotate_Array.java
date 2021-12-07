package tony.leetcode.feature.array;

// 189. 旋转数组
// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
// 输入: [1,2,3,4,5,6,7] 和 k = 3
// 输出: [5,6,7,1,2,3,4]

// 解释:
// 向右旋转 1 步: [7,1,2,3,4,5,6]
// 向右旋转 2 步: [6,7,1,2,3,4,5]
// 向右旋转 3 步: [5,6,7,1,2,3,4]

// 示例 2:
// 输入: [-1,-100,3,99] 和 k = 2
// 输出: [3,99,-1,-100]

// 解释:
// 向右旋转 1 步: [99,-1,-100,3]
// 向右旋转 2 步: [3,99,-1,-100]
// 说明:
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的原地算法。

public class Rotate_Array {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1); // 整个数组反向
        reverse(nums, 0, k - 1); // 前k个数反向，相当于原本后k个数被挪到前面，且因为反向两次保持顺序不变
        reverse(nums, k, n - 1); // 恢复原来0 ~ k-1个数的顺序
    }

    private void reverse(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        for (int i = begin, j = end; i <= mid; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
