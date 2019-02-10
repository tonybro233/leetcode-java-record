package tony.leetcode.feature.bit_operation;

// 260. 只出现一次的数字 III
// 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
// 找出只出现一次的那两个元素。
//
// 示例 :
// 输入: [1,2,1,3,2,5]
// 输出: [3,5]

// 注意：
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

public class Single_Number_III {

    public int[] singleNumber(int[] nums) {
        int num1 = 0, num2 = 0;
        int xor = 0;
        // 取所有异或，结果为两个单一值的异或值
        for (int num : nums) {
            xor ^= num;
        }

        // 取结果二进制第一个1，表示在该位上num1和num2不同
        int bit1 = 1;
        while((xor & 1) == 0) {
            xor >>= 1;
            bit1 <<= 1;
        }

        // 根据这个不同将数组分为两组，进行异或即可
        // 分组的时候相同的数必然在同一组，因此其他出现两次的数不影响结果
        for(int num : nums) {
            if ((num & bit1) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}
