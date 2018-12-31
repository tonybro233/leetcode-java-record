package tony.leetcode.feature.array;

import java.util.Arrays;

// 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
// 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

// 示例:
// 输入: [1,2,3,4]
// 输出: [24,12,8,6]
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

// 进阶：你可以在常数空间复杂度内完成这个题目吗？
// （ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

public class Product_of_Array_Except_Self {

    /**
     * 初始化输出数组各项为1，使用两个指针分别从两端依次计算后乘到各个位置上
     * 这种解法有点骚的
     */
    public int[] productExceptSelf(int[] nums) {
        int[] re = new int[nums.length];
        Arrays.fill(re, 1); // 初始化为1
        int left = 1, right = 1; // 乘数初始为1
        int n = nums.length;
        for (int i = 0;i < n;i++){
            re[i] *= left;
            re[n-i-1] *= right;
            left *= nums[i];
            right *= nums[n-i-1];
        }
        return re;
    }
}
