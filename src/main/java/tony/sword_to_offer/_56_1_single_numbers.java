package tony.sword_to_offer;

// 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
// 要求时间复杂度是O(n)，空间复杂度是O(1)。

// 示例 1：
// 输入：nums = [4,1,4,6]
// 输出：[1,6] 或 [6,1]

// 示例 2：
// 输入：nums = [1,2,10,4,1,4,3,3]
// 输出：[2,10] 或 [10,2]

public class _56_1_single_numbers {

    public int[] singleNumbers(int[] nums) {
        // 很难立刻想到分组以及这种分组方法
        // 得出两个单独数的异或值
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 找到异或结果的第一个非零位值, 使用它来将原有数组分为两份，分别执行异或
        int val = Integer.lowestOneBit(xor);
        int v1 = 0, v2 = 0;
        for (int num : nums) {
            if ((num & val) == 0) {
                v1 ^= num;
            } else {
                v2 ^= num;
            }
        }
        return new int[]{v1, v2};
    }

}
