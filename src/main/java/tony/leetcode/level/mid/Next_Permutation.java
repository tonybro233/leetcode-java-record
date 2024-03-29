package tony.leetcode.level.mid;

// 31. 下一个排列
// 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
// 必须原地修改，只允许使用额外常数空间。
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

import java.util.Arrays;

public class Next_Permutation {

    public void nextPermutation2(int[] nums) {
        // 要变大，则交换的值A和B(A在B左边) B > A
        // A必须是最靠近右边的一个可能值
        // 这可以得出A的后面都是递减的(否则轮不到A来交换)，这样起码A后面的一个值可以和A交换使得排列变大
        // 为了变大的幅度尽可能小，那么要找A后面比A大的最小值来当B
        // 因为A后面是递减的，所以只要从尾部开始遍历即可找到B
        // 为了变大的幅度尽可能小，AB交换后，B后面可能要重排为最小组合
        // 因为交换以后B的后面还是递减的，所以只需要反向就可以得到最小组合

        int i = nums.length - 2;
        // 保证i之后(不包括i)是递减的，并且nums[i] < nums[i+1]
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 从尾部开始取第一个比nums[i]大的值进行交换
            // 交换以后，i之后仍然是递减的
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 反向即可
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start){
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2){
            return;
        }
        int i = nums.length - 2;
        for (; i > 0;i--){
            if (nums[i] < nums[i+1]){
                break;
            }
        }
        int j = -1;
        int min = 0;
        for (int k = i+1; k < nums.length; k++){
            if (nums[k] > nums[i]){
                if (j == -1 || nums[k] < min){
                    min = nums[k];
                    j = k;
                }
            }
        }
        if (j == -1){
            Arrays.sort(nums);
        } else {
            nums[j] = nums[i];
            nums[i] = min;
            Arrays.sort(nums, i+1, nums.length);
        }
    }

}
